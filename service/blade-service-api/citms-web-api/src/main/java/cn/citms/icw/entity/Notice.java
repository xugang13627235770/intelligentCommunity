/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package cn.citms.icw.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import org.springblade.core.mp.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 通知公告表实体类
 *
 * @author Blade
 * @since 2020-04-22
 */
@Data
@TableName("sq_notice")
@ApiModel(value = "Notice对象", description = "通知公告表")
public class Notice {

	private static final long serialVersionUID = 1L;

	/**
	* ID
	*/
		@ApiModelProperty(value = "ID")
		@TableId("noticeId")
	private String noticeId;
	/**
	* 公告标题
	*/
		@ApiModelProperty(value = "公告标题")
		private String title;
	/**
	* 公告内容
	*/
		@ApiModelProperty(value = "公告内容")
		private String content;
	/**
	* 发布人
	*/
		@ApiModelProperty(value = "发布人")
		@TableField("userCode")
	private String userCode;
	/**
	* 公告类型
	*/
		@ApiModelProperty(value = "公告类型")
		@TableField("noticeType")
	private String noticeType;
	/**
	* 发布时间
	*/
		@ApiModelProperty(value = "发布时间")
		@TableField("pubTime")
	private LocalDateTime pubTime;
	/**
	* 到期时间
	*/
		@ApiModelProperty(value = "到期时间")
		@TableField("dueTime")
	private LocalDateTime dueTime;
	/**
	* 社区ID
	*/
		@ApiModelProperty(value = "社区ID")
		@TableField("communityId")
	private String communityId;
	/**
	* 经度
	*/
		@ApiModelProperty(value = "经度")
		private Double dqjd;
	/**
	* 纬度
	*/
		@ApiModelProperty(value = "纬度")
		private Double dqwd;


}
