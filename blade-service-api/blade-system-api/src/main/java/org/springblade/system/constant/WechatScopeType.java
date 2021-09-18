package org.springblade.system.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 微信的授权方式
 * @author Mengdl
 * @date 2021/09/18
 */
@AllArgsConstructor
@Getter
public enum WechatScopeType {
	/**
	 * 微信授权方式
	 */
	BASE("snsapi_base"),

	USER_INFO("snsapi_userinfo");

	private final String type;

	public boolean equals(String type) {
		return this.getType().equals(type);
	}
}
