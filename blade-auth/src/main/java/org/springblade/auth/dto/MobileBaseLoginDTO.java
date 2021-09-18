package org.springblade.auth.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 手机号登录
 * @author Mengdl
 * @date 2021/09/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class MobileBaseLoginDTO extends BaseLoginDTO{

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 公众号openid
	 */
	private String openid;

	/**
	 * 验证码
	 */
	private String verificationCode;

	/**
	 * 租户ID
	 */
	private String tenantId;

}
