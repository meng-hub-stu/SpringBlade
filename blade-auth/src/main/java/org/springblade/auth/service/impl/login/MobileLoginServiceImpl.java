package org.springblade.auth.service.impl.login;

import org.springblade.auth.annotation.Login;
import org.springblade.auth.annotation.MobileStep;
import org.springblade.auth.dto.BaseLoginDTO;
import org.springblade.auth.dto.LoginResultDTO;
import org.springblade.auth.dto.MobileBaseLoginDTO;
import org.springblade.auth.enums.LoginResultEnum;
import org.springblade.auth.enums.LoginTypeEnum;
import org.springblade.auth.enums.MobileLoginStepEnum;
import org.springblade.auth.service.LoginService;
import org.springblade.auth.service.MobileStepService;
import org.springblade.auth.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springblade.core.tool.utils.Func.*;

/**
 * 手机号登录
 * @author Mengdl
 * @date 2021/09/17
 */
@Login(LoginTypeEnum.MOBILE)
@Service
public class MobileLoginServiceImpl implements LoginService {

	private final Map<MobileLoginStepEnum, MobileStepService> mobileStepServiceMap;

	@Override
	public LoginResultDTO login(BaseLoginDTO baseLoginDTO) {

		return null;
	}

	@Autowired
	public MobileLoginServiceImpl(List<MobileStepService> mobileStepServiceList) {
		this.mobileStepServiceMap = mobileStepServiceList.stream().collect(Collectors.toMap(mobileStepService -> mobileStepService.getClass().getAnnotation(MobileStep.class).value(), Function.identity()));
	}

	@Override
	public BaseLoginDTO makeLoginParam(LoginVO loginVO) {
		return MobileBaseLoginDTO.builder()
			.mobile(loginVO.getMobile())
			.openid(loginVO.getOpenid())
			.verificationCode(loginVO.getVerificationCode())
			.tenantId(loginVO.getTenantId())
			.build();
	}

	@Override
	public LoginResultEnum check(LoginVO loginVO) {
		MobileLoginStepEnum step = MobileLoginStepEnum.select(loginVO.getTenantId());
		MobileStepService mobileStepService = mobileStepServiceMap.get(step);
		if(isEmpty(mobileStepService)){
			return LoginResultEnum.UNKNOWN;
		}
		return mobileStepService.check(loginVO);
	}

}
