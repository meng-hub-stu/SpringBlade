package org.springblade.auth.service.impl.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.auth.annotation.Login;
import org.springblade.auth.dto.BaseLoginDTO;
import org.springblade.auth.dto.LoginResultDTO;
import org.springblade.auth.dto.WechatBaseLoginDTO;
import org.springblade.auth.enums.LoginResultEnum;
import org.springblade.auth.enums.LoginTypeEnum;
import org.springblade.auth.service.LoginService;
import org.springblade.auth.service.SystemService;
import org.springblade.auth.service.UserWorkService;
import org.springblade.auth.utils.LoginTokenUtil;
import org.springblade.auth.vo.LoginVO;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springframework.stereotype.Service;

import static org.springblade.core.tool.utils.Func.isBlank;

/**
 * 微信code码登录
 * @author Mengdl
 * @date 2021/09/18
 */
@Login(LoginTypeEnum.WECHAT)
@Service
@Slf4j
@AllArgsConstructor
public class WechatLoginServiceImpl implements LoginService {

	private final SystemService systemService;
	private final UserWorkService userWorkService;

	@Override
	public LoginResultDTO login(BaseLoginDTO baseLoginDTO) {
		WechatBaseLoginDTO wechatBaseLogin = (WechatBaseLoginDTO)baseLoginDTO;
		//通过code获取openid，将获取到的微信个人信息存储在库里
		String openId = systemService.getOpenId(wechatBaseLogin.getCode());
		if(isBlank(openId)){
			return LoginResultDTO.failure(LoginResultEnum.GET_OPENID_FAILURE, null);
		}
		//查看绑定的信息
		LoginUserInfoDTO userInfo = userWorkService.queryBindUserInfoByOpenId(openId);
		if(jumpLoginPageCheck(userInfo)){

		}
		return LoginResultDTO.success(LoginTokenUtil.createLoginInfo(userInfo));
	}

	private boolean jumpLoginPageCheck(LoginUserInfoDTO userInfo) {
		return true;
	}

	@Override
	public BaseLoginDTO makeLoginParam(LoginVO loginVO) {
		return WechatBaseLoginDTO.builder().code(loginVO.getCode()).build();
	}

	@Override
	public LoginResultEnum check(LoginVO loginVO) {
		return isBlank(loginVO.getCode()) ? LoginResultEnum.CODE_BLANK : null;
	}

}
