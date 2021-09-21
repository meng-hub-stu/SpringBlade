package org.springblade.auth.service.impl;

import lombok.AllArgsConstructor;
import org.springblade.auth.service.SystemService;
import org.springblade.core.tool.api.R;
import org.springblade.system.feign.ISysClient;
import org.springframework.stereotype.Service;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@Service
@AllArgsConstructor
public class SystemServiceImpl implements SystemService {

	private final ISysClient sysClient;

	@Override
	public String getOpenId(String code) {
		return getData(sysClient.getOpenid(code));
	}

	private static <T> T getData(R<T> result) {
		return result.isSuccess() ? result.getData() : null;
	}

}
