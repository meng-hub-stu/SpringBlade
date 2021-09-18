package org.springblade.auth.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springblade.core.tool.api.IResultCode;

import javax.servlet.http.HttpServletResponse;

/**
 * @author wangchg
 */
@Getter
@AllArgsConstructor
public enum LoginResultEnum implements IResultCode {

	/**
	 * 登录成功
	 */
	SUCCESS(HttpServletResponse.SC_OK, ""),

	/**
	 * 业务员已离职
	 */
	LEAVE(HttpServletResponse.SC_BAD_REQUEST, "手机号对应的人员已离职，无权限登录，请核对"),

	/**
	 * 微信授权码不能为空
	 */
	CODE_BLANK(HttpServletResponse.SC_BAD_REQUEST, "微信授权码不能为空"),

	/**
	 * 获取openid失败
	 */
	GET_OPENID_FAILURE(HttpServletResponse.SC_BAD_REQUEST, "获取openid失败"),

	/**
	 * refresh_token不能为空
	 */
	REFRESH_TOKEN_BLANK(HttpServletResponse.SC_BAD_REQUEST, "refresh_token不能为空"),
	/**
	 * 未知的错误
	 */
	UNKNOWN(HttpServletResponse.SC_BAD_REQUEST, "未知的错误"),

	/**
	 * 请选择商户
	 */
	TENANT_BLANK(HttpServletResponse.SC_BAD_REQUEST, "请选择商户机构"),

	ACCOUNT_BLANK(HttpServletResponse.SC_BAD_REQUEST, "请先输入绑定工号"),

	ACCOUNT_ERROR(HttpServletResponse.SC_BAD_REQUEST, "请输入正确的绑定账号"),
	/**
	 * openid
	 */
	OPENID_BANK(HttpServletResponse.SC_BAD_REQUEST, "openid不能为空"),


	/**
	 * refresh_token无效或已过期
	 */
	REFRESH_TOKEN_EXPIRES(HttpServletResponse.SC_BAD_REQUEST, "refresh_token无效或已过期"),

	MOBILE_BLANK(HttpServletResponse.SC_BAD_REQUEST, "请先输入正确手机号"),

	VERIFICATION_CODE_BLANK(HttpServletResponse.SC_BAD_REQUEST, "验证码错误，请重新输入"),

	VERIFICATION_ERROR(HttpServletResponse.SC_BAD_REQUEST, "验证码错误，请重新输入"),

	SALESMAN_IS_EMPTY(HttpServletResponse.SC_BAD_REQUEST, "没有对应人员信息，无权限登录"),

	TENANT_CLOSE(HttpServletResponse.SC_BAD_REQUEST, "您无权限登录，请联系管理员"),


	/**
	 * 需跳转登录页面
	 */
	JUMP_LOGIN_PAGE(600, "请跳转登录页面"),

	/**
	 * 需要选择商户
	 */
	TENANT_SELECT(601, "请选择商户"),

	/**
	 * KEY为空
	 */
	KEY_BLANK(603, "错误的请求");

	final int code;

	final String message;

}
