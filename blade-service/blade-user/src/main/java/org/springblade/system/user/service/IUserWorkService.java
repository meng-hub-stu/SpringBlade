package org.springblade.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springblade.system.user.entity.UserWork;

/**
 * @Author Mengdexin
 * @date 2021 -09 -21 -17:12
 */
public interface IUserWorkService extends IService<UserWork> {

	LoginUserInfoDTO queryBindUserInfo(String openId);

}
