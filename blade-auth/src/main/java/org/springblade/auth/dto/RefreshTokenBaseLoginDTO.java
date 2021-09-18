package org.springblade.auth.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 刷新token登录
 * @author Mengdl
 * @date 2021/09/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class RefreshTokenBaseLoginDTO extends BaseLoginDTO{

	/**
	 * 刷新用token
	 */
	private String refreshToken;

}
