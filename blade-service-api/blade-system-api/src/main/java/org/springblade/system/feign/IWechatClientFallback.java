package org.springblade.system.feign;

import org.springframework.stereotype.Component;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Component
public class IWechatClientFallback implements IWechatClient{
	@Override
	public String snsAccessToken(String appId, String appsecret, String code, String snsGrantType) {
		return null;
	}

	@Override
	public String snsUserInfo(String accessToken, String openid, String lang) {
		return null;
	}
}
