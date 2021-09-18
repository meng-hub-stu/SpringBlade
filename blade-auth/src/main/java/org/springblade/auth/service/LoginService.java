package org.springblade.auth.service;

import org.springblade.auth.dto.BaseLoginDTO;
import org.springblade.auth.dto.LoginResultDTO;
import org.springblade.auth.enums.LoginResultEnum;
import org.springblade.auth.vo.LoginVO;

/**
 * @author Mengdl
 * @date 2021/09/17
 */
public interface LoginService {

	/**
	 * 基本校验参数
	 * @param loginVO 登录参数
	 * @return 校验结果
	 */
	LoginResultEnum check(LoginVO loginVO);

	/**
	 * 构建登录参数
	 * @param loginVO 登录参数
	 * @return 抽象类
	 */
	BaseLoginDTO makeLoginParam(LoginVO loginVO);

	/**
	 * 登录接口
	 * @param baseLoginDTO
	 * @return
	 */
	LoginResultDTO login(BaseLoginDTO baseLoginDTO);

}
