package org.springblade.auth.dto;

import lombok.Builder;
import lombok.Data;
import org.springblade.auth.enums.LoginResultEnum;

import static org.springblade.core.tool.utils.Func.isEmpty;

/**
 * 登录结果
 * @author Mengdl
 * @date 2021/09/18
 */
@Data
@Builder
public class LoginResultDTO {
	/**
	 * 登录结果
	 */
	private LoginResultEnum result;

	/**
	 * 登录信息
	 */
	private LoginInfoDTO loginInfo;

	public static LoginResultDTO success(LoginInfoDTO loginInfoDTO) {
		return LoginResultDTO.builder()
			.loginInfo(loginInfoDTO)
			.result(LoginResultEnum.SUCCESS)
			.build();
	}

	public static LoginResultDTO failure(LoginResultEnum result, LoginInfoDTO loginInfo) {
		return LoginResultDTO.builder()
			.result(result)
			.loginInfo(isEmpty(loginInfo) ? LoginInfoDTO.builder().build() : loginInfo)
			.build();
	}
}
