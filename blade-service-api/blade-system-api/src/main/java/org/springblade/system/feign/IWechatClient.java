package org.springblade.system.feign;

import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微信api调用
 * @author Mengdl
 * @date 2021/09/18
 */
@FeignClient(
	value = AppConstant.APPLICATION_SYSTEM_NAME,
	url = "${wechat.mp.url}",
	fallback = IWechatClientFallback.class
)
public interface IWechatClient {

	/**
	 * 通过code换取网页授权access_token
	 *
	 * @param appid     公众号的唯一标识
	 * @param appSecret 公众号的appsecret
	 * @param code      填写第一步获取的code参数
	 * @param grantType 填写为authorization_code
	 * @return 返回access_token
	 */
	@GetMapping("${wechat.mp.path.sns.token}")
	String snsAccessToken(
		@RequestParam("appid") String appid,
		@RequestParam("secret") String appSecret,
		@RequestParam("code") String code,
		@RequestParam(value = "grant_type", required = false, defaultValue = "authorization_code") String grantType
	);

	/**
	 *
	 * @param openid 微信的openid
	 * @param accessToken 网页的accessToken
	 * @param lang 返回地区的语言版本
	 * @return
	 */
	@GetMapping("${wechat.mp.path.sns.user_info}")
	String snsUserInfo(@RequestParam("access_token") String accessToken,
					   @RequestParam("openid") String openid,
					   @RequestParam(value = "lang", required = false, defaultValue = "zh_CN") String lang);

}
