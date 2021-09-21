package org.springblade.system.user.feign;

import org.springblade.core.launch.constant.AppConstant;
import org.springblade.core.tool.api.R;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@FeignClient(
	value = AppConstant.APPLICATION_USER_NAME,
	fallback = IUserWorkClientFallback.class
)
public interface IUserWorkClient {
	String API_PREFIX = "/userWork";

	/**
	 * 同步微信信息
	 *
	 * @param openid      openid
	 * @param accessToken token
	 * @return 返回是否成功
	 */
	@PostMapping(API_PREFIX + "/sync_wechat_user_info")
	R<Boolean> syncWechatUserInfo(@RequestParam("openid") String openid, @RequestParam("accessToken") String accessToken);

	/**
	 * 获取微信绑定的信息
	 * @param openId 微信openid
	 * @return 返回用户信息
	 */
	@GetMapping(API_PREFIX + "query-bind-userinfo")
	R<LoginUserInfoDTO> queryBindUserInfoByOpenId(@RequestParam("openid") String openId);
}
