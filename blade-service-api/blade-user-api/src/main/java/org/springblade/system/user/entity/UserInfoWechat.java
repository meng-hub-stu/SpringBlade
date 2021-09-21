package org.springblade.system.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springblade.core.tool.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Mengdl
 * @date 2021/09/18
 */
@ApiModel(value = "微信公众号信息表")
@Data
@Builder
@TableName(value = "blade_user_info_wechat")
public class UserInfoWechat {

	/**
	 * 主键ID
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "主键ID")
	private Long id;

	/**
	 * 微信openid
	 */
	@TableField(value = "openid")
	@ApiModelProperty(value = "微信openid")
	private String openid;

	/**
	 * 用户昵称
	 */
	@TableField(value = "nickname")
	@ApiModelProperty(value = "用户昵称")
	private String nickname;

	/**
	 * 性别;1-男，2-女，3-未知
	 */
	@TableField(value = "sex")
	@ApiModelProperty(value = "性别;1-男，2-女，3-未知")
	private Integer sex;

	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 */
	@TableField(value = "headimgurl")
	@ApiModelProperty(value = "用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。")
	private String headimgurl;

	/**
	 * 用户所在城市
	 */
	@TableField(value = "country")
	@ApiModelProperty(value = "用户所在城市")
	private String country;

	/**
	 * 用户所在省份
	 */
	@TableField(value = "province")
	@ApiModelProperty(value = "用户所在省份")
	private String province;

	/**
	 * 用户所在城市
	 */
	@TableField(value = "city")
	@ApiModelProperty(value = "用户所在城市")
	private String city;

	/**
	 * 同步时间
	 */
	@TableField(value = "sync_time")
	@ApiModelProperty(value = "同步时间")
	private Date syncTime;

	/**
	 * unionid
	 */
	@TableField(value = "unionid")
	@ApiModelProperty(value = "unionid")
	private String unionid;

	/**
	 * 是否删除;0-未删除,1-已删除
	 */
	@TableLogic
	@TableField(value = "is_deleted")
	@ApiModelProperty(value = "是否删除;0-未删除,1-已删除")
	private Integer isDeleted;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@ApiModelProperty(value = "创建时间")
	@DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
	@JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
	private Date createTime;

	/**
	 * 修改时间
	 */
	@TableField(value = "update_time")
	@ApiModelProperty(value = "修改时间")
	@DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
	@JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
	private Date updateTime;

}
