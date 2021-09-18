package org.springblade.auth.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 登录返回信息
 *
 * @author mengdexin
 */
@ApiModel("登录响应对象")
@Data
@Builder
public class LoginInfoDTO {

	@ApiModelProperty(value = "令牌")
	private String accessToken;

	@ApiModelProperty(value = "令牌类型")
	private String tokenType;

	@ApiModelProperty(value = "刷新令牌")
	private String refreshToken;

	@ApiModelProperty(value = "用户ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long userId;

	@ApiModelProperty(value = "微信用户ID")
	@JsonSerialize(using = ToStringSerializer.class)
	private Long wechatId;

	@ApiModelProperty(value = "租户ID")
	private String tenantId;

	@ApiModelProperty(value = "过期时间")
	private Integer expiresIn;

	@ApiModelProperty(value = "openid")
	private String openid;

	@ApiModelProperty(value = "手机登录验证")
	private String key;

}
