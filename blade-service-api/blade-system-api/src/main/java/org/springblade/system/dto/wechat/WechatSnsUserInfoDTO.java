package org.springblade.system.dto.wechat;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Author Mengdexin
 * @date 2021 -09 -21 -16:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WechatSnsUserInfoDTO extends WechatBaseUserInfoDTO{

	/**
	 * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
	 */
	private List<String> privilege;

}
