package org.springblade.auth.service.impl.step;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.auth.annotation.MobileStep;
import org.springblade.auth.enums.LoginResultEnum;
import org.springblade.auth.enums.MobileLoginStepEnum;
import org.springblade.auth.service.MobileService;
import org.springblade.auth.service.MobileStepService;
import org.springblade.auth.vo.LoginVO;
import org.springframework.stereotype.Service;

import static org.springblade.core.tool.utils.Func.*;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@MobileStep(MobileLoginStepEnum.LOGIN)
@Slf4j
@AllArgsConstructor
public class MobileLoginStepServiceImpl implements MobileStepService {

	private final MobileService mobileService;


	@Override
	public LoginResultEnum check(LoginVO loginVO) {
		if(isBlank(loginVO.getMobile())){
			return LoginResultEnum.MOBILE_BLANK;
		}
		if(isBlank(loginVO.getOpenid())){
			return LoginResultEnum.OPENID_BANK;
		}
		if(isBlank(loginVO.getVerificationCode())){
			return LoginResultEnum.VERIFICATION_CODE_BLANK;
		}
		if(!mobileService.check(loginVO.getMobile(), loginVO.getVerificationCode())){
			return LoginResultEnum.VERIFICATION_CODE_BLANK;
		}
		return null;
	}

}
