package org.springblade.system.user.feign;

import org.springframework.stereotype.Component;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Component
public class IUserWorkClientFallback implements IUserWorkClient{

	@Override
	public void syncWechatUserInfo(String openid, String accessToken) {

	}
}
