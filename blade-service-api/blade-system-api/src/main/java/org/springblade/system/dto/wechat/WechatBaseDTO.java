package org.springblade.system.dto.wechat;

import lombok.Data;

/**
 * 微信返回码信息
 * @author Mengdl
 * @date 2021/09/18
 */
@Data
public class WechatBaseDTO {

	/**
	 * 返回码
	 */
	private Integer errcode;

	/**
	 * 信息
	 */
	private String errmsg;

}
