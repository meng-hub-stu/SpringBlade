package org.springblade.auth.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springblade.auth.annotation.Login;
import org.springblade.auth.dto.BaseLoginDTO;
import org.springblade.auth.dto.LoginInfoDTO;
import org.springblade.auth.dto.LoginResultDTO;
import org.springblade.auth.enums.LoginResultEnum;
import org.springblade.auth.enums.LoginTypeEnum;
import org.springblade.auth.service.LoginService;
import org.springblade.auth.vo.LoginVO;
import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springblade.core.tool.utils.Func.*;

/**
 * 微信授权登录
 * @author Mengdl
 * @date 2021/09/17
 */
@RestController
@Api(value = "微信授权认证", tags = "授权接口")
@RequestMapping(value = "/wechat")
public class LoginController {

	private final Map<LoginTypeEnum, LoginService> loginServiceMap;

	@Autowired
	public LoginController(List<LoginService> loginServiceList){
		this.loginServiceMap = loginServiceList.stream().collect(Collectors.toMap(loginService -> loginService.getClass().getAnnotation(Login.class).value(), Function.identity()));

	}

	@ApiImplicitParams({
		@ApiImplicitParam(value = "登录方式", name = "loginType", dataType = "string", paramType = "form"),
		@ApiImplicitParam(value = "微信授权码", name = "code", dataType = "string", paramType = "form"),
		@ApiImplicitParam(value = "公众号openid", name = "openid", dataType = "string", paramType = "form"),
		@ApiImplicitParam(value = "刷新token", name = "refreshToken", dataType = "string", paramType = "form"),
		@ApiImplicitParam(value = "手机号", name = "mobile", dataType = "string", paramType = "form"),
		@ApiImplicitParam(value = "短信验证码", name = "verificationCode", dataType = "string", paramType = "form"),
		@ApiImplicitParam(value = "商户ID", name = "tenantId", dataType = "string", paramType = "form"),
		@ApiImplicitParam(value = "租户登录KEY", name = "key", dataType = "string", paramType = "form")
	})
	@ApiOperation(value = "微信登录接口")
	@PostMapping(value = "login")
	public R<LoginInfoDTO> login(@ApiIgnore LoginVO loginVO) {
		LoginTypeEnum loginTypeEnum = LoginTypeEnum.find(loginVO.getLoginType());
		//获取登录方式
		LoginService loginService = loginServiceMap.get(loginTypeEnum);
		//验证每种登录方式的参数
		LoginResultEnum loginResultEnum = loginService.check(loginVO);
		if(isNotEmpty(loginResultEnum)){
			return R.fail(loginResultEnum);
		}
		//构建登录参数
		BaseLoginDTO baseLoginDTO = loginService.makeLoginParam(loginVO);
		//登录系统
		LoginResultDTO loginResultDTO = loginService.login(baseLoginDTO);
		//登录结果
		LoginResultEnum result = loginResultDTO.getResult();
		if(LoginResultEnum.SUCCESS.equals(result) && !LoginTypeEnum.REFRESH_TOKEN.equals(loginTypeEnum)){

		}
		return R.data(result.getCode(), loginResultDTO.getLoginInfo(), result.getMessage());
	}

}
