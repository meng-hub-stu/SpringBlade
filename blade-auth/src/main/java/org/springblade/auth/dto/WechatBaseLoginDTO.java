package org.springblade.auth.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class WechatBaseLoginDTO extends BaseLoginDTO{
	/**
	 * 微信授权码
	 */
	private String code;

}
