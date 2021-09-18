package org.springblade.system.feign;

import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.openfeign.FeignClient;

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
	 * 获取accessToken
	 * @param appId
	 * @param appsecret
	 * @param code
	 * @param snsGrantType
	 * @return
	 */
	String snsAccessToken(String appId, String appsecret, String code, String snsGrantType);
}
