package org.springblade.system.service.impl;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import cn.hutool.crypto.SecureUtil;
import org.springblade.system.constant.WechatScopeType;
import org.springblade.system.dto.wechat.SnsAccessTokenDTO;
import org.springblade.system.dto.wechat.WechatBaseUserInfoDTO;
import org.springblade.system.dto.wechat.WechatSnsUserInfoDTO;
import org.springblade.system.props.WechatMpProperties;
import org.springblade.system.service.IWechatRemoteService;
import org.springblade.system.service.IWechatService;
import org.springblade.system.user.feign.IUserWorkClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.springblade.core.tool.utils.Func.copy;
import static org.springblade.core.tool.utils.Func.isNotEmpty;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@AllArgsConstructor
@Service
@Slf4j
public class WechatServiceImpl implements IWechatService {

	private final IWechatRemoteService wechatRemoteService;

	private final IUserWorkClient userWorkClient;

	private final WechatMpProperties wechatMpProperties;

	@Override
	public boolean verifyUrl(String signature, String timestamp, String nonce) {
		ArrayList<String> str = Lists.newArrayList(timestamp, signature, nonce);
		String signStr = str.stream().sorted().collect(Collectors.joining());
		String sign = SecureUtil.sha1(signStr);
		return sign.equals(signature);
	}

	@Override
	public WechatBaseUserInfoDTO getUserInfo(String openid, String accessToken) {
		WechatSnsUserInfoDTO wechatSnsUserInfoDTO = wechatRemoteService.snsUserInfo(openid, accessToken);
		return copy(wechatSnsUserInfoDTO, WechatBaseUserInfoDTO.class);
	}

	@Override
	public String getOpenid(String code) {
		//通过网页授权码获取微信数据
		SnsAccessTokenDTO sat =  wechatRemoteService.accessToken(code);
		if(isNotEmpty(sat)){
			//将微信获得的用户信息信息同步到数据库中
			if(WechatScopeType.USER_INFO.equals(sat.getScope())){
				userWorkClient.syncWechatUserInfo(sat.getOpenid(), sat.getAccessToken());
			}
			return sat.getOpenid();
		}
		return null;
	}
}
