package org.springblade.system.service;

import org.springblade.system.dto.wechat.SnsAccessTokenDTO;
import org.springblade.system.dto.wechat.WechatSnsUserInfoDTO;

/**
 * 微信拉取远程数据的接口
 * @author Mengdl
 * @date 2021/09/18
 */
public interface IWechatRemoteService {

	/**
	 * 通过授权码获取token
	 * @param code
	 * @return
	 */
	SnsAccessTokenDTO accessToken(String code);

	/**
	 * 获取微信用户信息
	 * @param openid 微信的openid
	 * @param accessToken 微信的token
	 * @return 微信用户信息
	 */
	WechatSnsUserInfoDTO snsUserInfo(String openid, String accessToken);

}
