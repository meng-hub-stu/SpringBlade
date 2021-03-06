package org.springblade.system.dto.wechat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SnsAccessTokenDTO extends WechatBaseDTO{

	/**
	 * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
	 */
	@JsonProperty("access_token")
	private String accessToken;

	/**
	 * access_token接口调用凭证超时时间，单位（秒）
	 */
	@JsonProperty("expires_in")
	private Long expiresIn;

	/**
	 * 用户刷新access_token
	 */
	@JsonProperty("refresh_token")
	private String refreshToken;

	/**
	 * 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
	 */
	private String openid;

	/**
	 * 用户授权的作用域，使用逗号（,）分隔
	 */
	private String scope;
}
