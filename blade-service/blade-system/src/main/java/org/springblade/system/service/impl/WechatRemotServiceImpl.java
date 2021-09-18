package org.springblade.system.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.system.dto.wechat.SnsAccessTokenDTO;
import org.springblade.system.feign.IWechatClient;
import org.springblade.system.props.WechatMpProperties;
import org.springblade.system.service.IWechatRemoteService;
import org.springframework.stereotype.Service;

import static org.springblade.core.tool.utils.Func.*;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@AllArgsConstructor
@Slf4j
public class WechatRemotServiceImpl implements IWechatRemoteService {

	private final IWechatClient wechatClient;

	private final WechatMpProperties wechatMpProperties;

	private static final String SNS_GRANT_TYPE = "authorization_code";

	@Override
	public SnsAccessTokenDTO accessToken(String code) {
		String satStr = wechatClient.snsAccessToken(
			wechatMpProperties.getAppId(),
			wechatMpProperties.getAppsecret(),
			code,
			SNS_GRANT_TYPE);
		if(isNotBlank(satStr)){
			JSON.parseObject(satStr, SnsAccessTokenDTO.class);
		}
		return null;
	}
}
