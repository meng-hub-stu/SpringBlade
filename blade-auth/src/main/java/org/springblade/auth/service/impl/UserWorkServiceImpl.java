package org.springblade.auth.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.auth.service.UserWorkService;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springframework.stereotype.Service;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@AllArgsConstructor
public class UserWorkServiceImpl implements UserWorkService {

	@Override
	public LoginUserInfoDTO queryBindUserInfoByOpenId(String openId) {
		return null;
	}
}
