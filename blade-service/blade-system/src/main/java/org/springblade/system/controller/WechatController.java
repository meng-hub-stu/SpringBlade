package org.springblade.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.tool.api.R;
import org.springblade.system.service.IWechatService;
import org.springframework.web.bind.annotation.*;

import static org.springblade.core.tool.utils.Func.isNotBlank;

/**
 * 微信
 * @author Mengdl
 * @date 2021/09/18
 */
@Api(value = "微信")
@RequestMapping("/wechat")
@AllArgsConstructor
@RestController
@Slf4j
public class WechatController {

	private final IWechatService wechatService;

	@ApiOperation(value = "获取openid")
	@GetMapping("/js/openid")
	public R<String> openid(@ApiParam("网页授权码") @RequestParam("code") String code) {
		String openid = wechatService.getOpenid(code);
		return isNotBlank(openid) ? R.data(openid) : R.fail("获取openid失败");
	}

	@GetMapping("/mp/msg")
	@ApiOperation(value = "校验接口配置信息")
	public String check(String signature, String timestamp, String nonce, String echostr){
		if(wechatService.verifyUrl(signature, timestamp, nonce)){
			return echostr;
		}
		return null;
	}

	@PostMapping(value = "/mp/msg")
	@ApiOperation(value = "校验接口配置信息")
	public String msg(String signature, String timestamp, String nonce, String openid) {
		if (wechatService.verifyUrl(signature, timestamp, nonce)) {
			log.error("验签失败[openid:{}]", openid);
		}
		return "success";
	}

	@GetMapping(value = "/code")
	@ApiOperation(value = "网页授权获取code码")
	public String code(){
		return "success";
	}

}
