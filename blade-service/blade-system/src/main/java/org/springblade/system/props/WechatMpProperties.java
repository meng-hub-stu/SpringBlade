package org.springblade.system.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信公众号配置信息
 * @author Mengdl
 * @date 2021/09/18
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "wechat.mp")
public class WechatMpProperties {

	/**
	 * 微信地址
	 */
	private String url;

	/**
	 * 校验token
	 */
	private String token;

	/**
	 * appID
	 */
	private String appId;

	/**
	 * appsecret
	 */
	private String appsecret;

	/**
	 * 刷新等待时间
	 */
	private Long refreshWaitTime;

	/**
	 * 域名
	 */
	private String domain;

}
