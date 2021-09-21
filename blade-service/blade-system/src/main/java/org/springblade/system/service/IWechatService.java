package org.springblade.system.service;

import org.springblade.system.dto.wechat.WechatBaseUserInfoDTO;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
public interface IWechatService {

	/**
	 * 获取微信的openid
	 * @param code 授权码
	 * @return openid
	 */
	String getOpenid(String code);

	/**
	 * 获取用户的基本信息
	 * @param openid 微信的openid
	 * @param accessToken 网页token
	 * @return 用户信息
	 */
	WechatBaseUserInfoDTO getUserInfo(String openid, String accessToken);
}
