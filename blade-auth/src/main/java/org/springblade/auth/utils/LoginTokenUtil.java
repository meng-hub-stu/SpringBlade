package org.springblade.auth.utils;

import org.springblade.auth.dto.LoginInfoDTO;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springblade.system.user.entity.UserWork;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
public class LoginTokenUtil {


	public static LoginInfoDTO createLoginInfo(LoginUserInfoDTO userInfo) {
		UserWork userWork = userInfo.getUserWork();

		return null;
	}
}
