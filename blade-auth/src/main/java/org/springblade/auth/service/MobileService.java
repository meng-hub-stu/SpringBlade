package org.springblade.auth.service;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
public interface MobileService {
	/**
	 * 校验短信验证码
	 * @param mobile 手机号
	 * @param verificationCode 验证码
	 * @return 是否成功
	 */
	boolean check(String mobile, String verificationCode);

}
