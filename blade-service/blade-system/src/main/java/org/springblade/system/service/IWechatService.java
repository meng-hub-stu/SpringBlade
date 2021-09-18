package org.springblade.system.service;

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


}
