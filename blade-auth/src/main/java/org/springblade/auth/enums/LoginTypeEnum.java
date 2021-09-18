package org.springblade.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 登录授权方式
 * @author Mengdl
 * @date 2021/09/17
 */
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {
	/**
	 * 微信授权码登录
	 */
	WECHAT("wechat"),
	/**
	 * 手机号登录
	 */
	MOBILE("mobile"),
	/**
	 * 刷新token
	 */
	REFRESH_TOKEN("refresh_token");

	private final String type;

	public static LoginTypeEnum find(String type) {
		for (LoginTypeEnum loginTypeEnum : values()) {
			if (loginTypeEnum.getType().equals(type)) {
				return loginTypeEnum;
			}
		}
		return null;
	}
}
