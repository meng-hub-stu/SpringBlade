package org.springblade.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static org.springblade.core.tool.utils.Func.isNotBlank;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Getter
@AllArgsConstructor
public enum MobileLoginStepEnum {
	/**
	 * 手机号登录
	 */
	LOGIN,
	/**
	 * 租户选择
	 */
	TENANT;

	/**
	 * 判断当前步骤
	 *
	 * @param tenantId 租户ID
	 * @return 返回结果
	 */
	public static MobileLoginStepEnum select(String tenantId) {
		boolean tenantNotBlank = isNotBlank(tenantId);
		if (tenantNotBlank) {
			return TENANT;
		} else {
			return LOGIN;
		}
	}

}
