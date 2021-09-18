package org.springblade.auth.service.impl.login;

import org.springblade.auth.annotation.Login;
import org.springblade.auth.dto.BaseLoginDTO;
import org.springblade.auth.dto.RefreshTokenBaseLoginDTO;
import org.springblade.auth.enums.LoginResultEnum;
import org.springblade.auth.enums.LoginTypeEnum;
import org.springblade.auth.service.LoginService;
import org.springblade.auth.vo.LoginVO;
import org.springframework.stereotype.Service;

import static org.springblade.core.tool.utils.Func.isBlank;

/**
 * 刷新token
 * @author Mengdl
 * @date 2021/09/17
 */
@Login(LoginTypeEnum.REFRESH_TOKEN)
@Service
public class RefreshTokenLoginServiceImpl implements LoginService {

	@Override
	public BaseLoginDTO makeLoginParam(LoginVO loginVO) {
		return RefreshTokenBaseLoginDTO.builder()
			.refreshToken(loginVO.getRefreshToken())
			.build();
	}

	@Override
	public LoginResultEnum check(LoginVO loginVO) {
		return isBlank(loginVO.getRefreshToken()) ? LoginResultEnum.REFRESH_TOKEN_BLANK : null;
	}

}
