package org.springblade.system.user.feign;

import org.springblade.core.launch.constant.AppConstant;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@FeignClient(
	value = AppConstant.APPLICATION_USER_NAME,
	fallback = IUserWorkClientFallback.class
)
public interface IUserWorkClient {


	void syncWechatUserInfo(String openid, String accessToken);
}
