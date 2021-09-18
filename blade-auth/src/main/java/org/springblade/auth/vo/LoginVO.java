package org.springblade.auth.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 展业端登录
 *
 * @author wangchg
 */
@Data
public class LoginVO {

	/**
	 * 微信授权码
	 */
	private String code;

	/**
	 * 公众号openid
	 */
	private String openid;

	/**
	 * 刷新token
	 */
	private String refreshToken;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 短信验证码
	 */
	private String verificationCode;

	/**
	 * 商户ID
	 */
	private String tenantId;

	/**
	 * 登录方式
	 */
	@NotBlank(message = "登录方式不能为空")
	private String loginType;


	/**
	 * 商户选择与账号绑定需要的KEY
	 */
	private String key;

}
