package org.springblade.auth.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.auth.service.UserWorkService;
import org.springblade.core.tool.api.R;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springblade.system.user.feign.IUserWorkClient;
import org.springframework.stereotype.Service;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@AllArgsConstructor
public class UserWorkServiceImpl implements UserWorkService {

	private final IUserWorkClient userWorkClient;

	@Override
	public LoginUserInfoDTO queryBindUserInfoByOpenId(String openId) {
		return getData(userWorkClient.queryBindUserInfoByOpenId(openId));
	}

	private static <T> T getData(R<T> result) {
		return result.isSuccess() ? result.getData() : null;
	}

}
