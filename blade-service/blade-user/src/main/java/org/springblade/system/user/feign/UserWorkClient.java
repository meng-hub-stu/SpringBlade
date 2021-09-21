package org.springblade.system.user.feign;

import lombok.AllArgsConstructor;
import org.springblade.core.tool.api.R;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springblade.system.user.service.IUserInfoWechatService;
import org.springblade.system.user.service.IUserWorkService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Mengdexin
 * @date 2021 -09 -21 -15:26
 */
@RestController
@AllArgsConstructor
public class UserWorkClient implements IUserWorkClient{

	private final IUserWorkService userWorkService;
	private final IUserInfoWechatService userInfoWechatService;

	@Override
	public R<LoginUserInfoDTO> queryBindUserInfoByOpenId(String openId) {
		return R.data(userWorkService.queryBindUserInfo(openId));
	}

	@Override
	public R<Boolean> syncWechatUserInfo(String openid, String accessToken) {
		return R.data(userInfoWechatService.syncUserInfo(openid, accessToken));
	}

}
