package org.springblade.system.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.system.dto.wechat.SnsAccessTokenDTO;
import org.springblade.system.dto.wechat.WechatSnsUserInfoDTO;
import org.springblade.system.feign.IWechatClient;
import org.springblade.system.props.WechatMpProperties;
import org.springblade.system.service.IWechatRemoteService;
import org.springframework.stereotype.Service;

import static org.springblade.core.tool.utils.Func.isEmpty;
import static org.springblade.core.tool.utils.Func.isNotBlank;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@AllArgsConstructor
@Slf4j
public class WechatRemotServiceImpl implements IWechatRemoteService {

	private static final String LANG = "zh_CN";

	private static final Integer WECHAT_SUCCESS_CODE = 0;

	private final IWechatClient wechatClient;

	private final WechatMpProperties wechatMpProperties;

	private static final String SNS_GRANT_TYPE = "authorization_code";

	@Override
	public WechatSnsUserInfoDTO snsUserInfo(String openid, String accessToken) {
		String snsStr = wechatClient.snsUserInfo(
			accessToken,
			openid,
			LANG
		);
		if(isNotBlank(snsStr)){
			WechatSnsUserInfoDTO snsUserInfoDTO = JSON.parseObject(snsStr, WechatSnsUserInfoDTO.class);
			if(isEmpty(snsUserInfoDTO.getErrcode()) || WECHAT_SUCCESS_CODE.equals(snsUserInfoDTO.getErrcode())){
				return snsUserInfoDTO;
			} else {
				log.error("通过openid和accessToken获取微信用户信息失败[openid:{},accessToken:{},errcode:{},errmsg:{}]",openid, accessToken, snsUserInfoDTO.getErrcode(), snsUserInfoDTO.getErrmsg());
			}
		} else {
			log.error("通过openid和accessToken获取微信用户信息失败[openid:{},accessToken:{}]", openid, accessToken);
		}
		return null;
	}

	@Override
	public SnsAccessTokenDTO accessToken(String code) {
		String satStr = wechatClient.snsAccessToken(
			wechatMpProperties.getAppId(),
			wechatMpProperties.getAppsecret(),
			code,
			SNS_GRANT_TYPE);
		if(isNotBlank(satStr)){
			SnsAccessTokenDTO sat = JSON.parseObject(satStr, SnsAccessTokenDTO.class);
			if(isEmpty(sat.getErrcode()) && WECHAT_SUCCESS_CODE.equals(sat.getErrcode())){
				return sat;
			} else {
				log.error("网页授权获取access_token失败[code:{},errcode:{},errmsg:{}]", code, sat.getErrcode(), sat.getErrmsg());
			}
		} else {
			log.error("网页授权获取access_token失败[code:{}]", code);
		}
		return null;
	}
}
