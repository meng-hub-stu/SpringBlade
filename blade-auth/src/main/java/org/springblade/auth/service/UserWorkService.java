package org.springblade.auth.service;

import org.springblade.system.user.dto.LoginUserInfoDTO;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
public interface UserWorkService {

	LoginUserInfoDTO queryBindUserInfoByOpenId(String openId);

}
