package org.springblade.system.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springblade.system.user.entity.UserWork;
import org.springblade.system.user.mapper.UserWorkMapper;
import org.springblade.system.user.service.IUserInfoWechatService;
import org.springblade.system.user.service.IUserWorkService;
import org.springframework.stereotype.Service;

/**
 * @Author Mengdexin
 * @date 2021 -09 -21 -17:14
 */
@AllArgsConstructor
@Service
@Slf4j
public class IUserWorkServiceImpl extends ServiceImpl<UserWorkMapper, UserWork> implements IUserWorkService {

	private final IUserInfoWechatService userInfoWechatService;

	@Override
	public LoginUserInfoDTO queryBindUserInfo(String openId) {
		//查询微信信息
		//查询绑定信息
		//查询业务员信息
		//返回数据
		return null;
	}
}
