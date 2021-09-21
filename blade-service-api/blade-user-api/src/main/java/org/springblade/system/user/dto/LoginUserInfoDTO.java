package org.springblade.system.user.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import lombok.Builder;
import lombok.Data;
import org.springblade.system.user.entity.UserInfoWechat;
import org.springblade.system.user.entity.UserWork;

/**
 * 微信登录的信息
 * @author Mengdl
 * @date 2021/09/18
 */
@Builder
@Data
public class LoginUserInfoDTO {
	/**
	 * 业务员信息
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private UserWork userWork;

	/**
	 * 微信信息
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private UserInfoWechat userInfoWechat;

	/**
	 * 是否已离职，true是，false否
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private Boolean hasLeave;

	/**
	 * 是否是销售人员，true是，false否
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private Boolean isSalesman;

	/**
	 * 是否已绑定
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private Boolean hasBind;

	/**
	 * 是否开通展业端
	 */
	@JsonSerialize(nullsUsing = NullSerializer.class)
	private Boolean hasPpb;

}
