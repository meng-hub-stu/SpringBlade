package org.springblade.system.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.DateUtil;
import org.springblade.system.dto.wechat.WechatBaseUserInfoDTO;
import org.springblade.system.feign.ISysClient;
import org.springblade.system.user.dto.LoginUserInfoDTO;
import org.springblade.system.user.entity.UserInfoWechat;
import org.springblade.system.user.mapper.UserInfoWechatMapper;
import org.springblade.system.user.service.IUserInfoWechatService;
import org.springframework.stereotype.Service;

import static org.springblade.core.tool.utils.Func.*;

/**
 * 微信信息实现类
 * @Author Mengdexin
 * @date 2021 -09 -21 -15:32
 */
@AllArgsConstructor
@Service
@Slf4j
public class UserInfoWechatServiceImpl extends ServiceImpl<UserInfoWechatMapper, UserInfoWechat> implements IUserInfoWechatService {

	private final ISysClient sysClient;

	@Override
	public boolean syncUserInfo(String openid, String accessToken) {
		//查询历史数据，看看是否获取过数据
		UserInfoWechat userInfoWechat = lambdaQuery().eq(UserInfoWechat::getOpenid, openid).one();
		if(isEmpty(userInfoWechat) || isEmpty(userInfoWechat.getSyncTime())){
			//重新获取数据，在微信中获取数据
			R<WechatBaseUserInfoDTO> wechatBaseUserInfoResult = sysClient.wechatUserInfo(openid, accessToken);
			if(!wechatBaseUserInfoResult.isSuccess()){
				log.error("获取微信用户信息失败[openid:{}]", openid);
				return false;
			}
			//新增微信数据
			WechatBaseUserInfoDTO wechatUserInfo = wechatBaseUserInfoResult.getData();
			UserInfoWechat uw = UserInfoWechat.builder()
				.city(wechatUserInfo.getCity())
				.syncTime(DateUtil.now())
				.openid(openid)
				.nickname(wechatUserInfo.getNickname())
				.country(wechatUserInfo.getCountry())
				.sex(wechatUserInfo.getSex())
				.headimgurl(wechatUserInfo.getHeadimgurl())
				.unionid(wechatUserInfo.getUnionid())
				.province(wechatUserInfo.getProvince())
				.build();
			if(isNotEmpty(userInfoWechat)){
				uw.setId(userInfoWechat.getId());
			}
			return this.saveOrUpdate(uw);
		} else {
			log.info("用户信息已经同步-[openid:{}]", openid);
		}
		return false;
	}

}
