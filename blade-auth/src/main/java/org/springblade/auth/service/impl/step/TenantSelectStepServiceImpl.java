package org.springblade.auth.service.impl.step;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.auth.annotation.MobileStep;
import org.springblade.auth.enums.LoginResultEnum;
import org.springblade.auth.enums.MobileLoginStepEnum;
import org.springblade.auth.service.MobileStepService;
import org.springblade.auth.vo.LoginVO;
import org.springframework.stereotype.Service;

import static org.springblade.core.tool.utils.Func.*;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@Slf4j
@MobileStep(MobileLoginStepEnum.TENANT)
@AllArgsConstructor
public class TenantSelectStepServiceImpl implements MobileStepService {


	@Override
	public LoginResultEnum check(LoginVO loginVO) {
		if(isBlank(loginVO.getMobile())){
			return LoginResultEnum.MOBILE_BLANK;
		}
		if(isBlank(loginVO.getOpenid())){
			return LoginResultEnum.OPENID_BANK;
		}
		if(isBlank(loginVO.getTenantId())){
			return LoginResultEnum.TENANT_BLANK;
		}
		return null;
	}

}
