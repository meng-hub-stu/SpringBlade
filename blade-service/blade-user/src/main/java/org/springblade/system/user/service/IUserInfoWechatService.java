package org.springblade.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springblade.system.user.entity.UserInfoWechat;

/**
 * 微信信息服务接口
 * @Author Mengdexin
 * @date 2021 -09 -21 -15:28
 */
public interface IUserInfoWechatService extends IService<UserInfoWechat> {

	/**
	 * 同步用户信息
	 *
	 * @param openid      openid
	 * @param accessToken 授权token
	 * @return 返回是否成功
	 */
	boolean syncUserInfo(String openid, String accessToken);

}
