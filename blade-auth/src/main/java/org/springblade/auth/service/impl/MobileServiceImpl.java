package org.springblade.auth.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springblade.auth.service.MobileService;
import org.springframework.stereotype.Service;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@Slf4j
public class MobileServiceImpl implements MobileService {

	@Override
	public boolean check(String mobile, String verificationCode) {
		return false;
	}

}
