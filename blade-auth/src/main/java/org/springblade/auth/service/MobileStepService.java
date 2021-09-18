package org.springblade.auth.service;

import org.springblade.auth.enums.LoginResultEnum;
import org.springblade.auth.vo.LoginVO;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
public interface MobileStepService {
	/**
	 * 步骤不一样，检查校验是不一样的
	 * @param loginVO
	 * @return
	 */
	LoginResultEnum check(LoginVO loginVO);

}
