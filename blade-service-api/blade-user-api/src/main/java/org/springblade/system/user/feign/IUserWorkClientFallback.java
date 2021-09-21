package org.springblade.system.user.feign;

import org.springblade.core.tool.api.R;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springframework.stereotype.Component;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Component
public class IUserWorkClientFallback implements IUserWorkClient{

	@Override
	public R<Boolean> syncWechatUserInfo(String openid, String accessToken) {
		return R.fail("同步微信用户信息失败");
	}

	@Override
	public R<LoginUserInfoDTO> queryBindUserInfoByOpenId(String openId) {
		return R.fail("获取微信绑定信息失败");
	}
}
