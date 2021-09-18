package org.springblade.auth.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.auth.service.SystemService;
import org.springframework.stereotype.Service;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@AllArgsConstructor
public class SystemServiceImpl implements SystemService {

	@Override
	public String getOpenId(String code) {
		return null;
	}
}
