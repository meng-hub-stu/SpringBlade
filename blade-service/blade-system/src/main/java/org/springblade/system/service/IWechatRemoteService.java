package org.springblade.system.service;

import org.springblade.system.dto.wechat.SnsAccessTokenDTO;

/**
 * 微信接口
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

}
