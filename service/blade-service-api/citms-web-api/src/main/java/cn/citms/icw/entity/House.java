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
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 门户信息实体类
 *
 * @author Blade
 * @since 2020-04-22
 */
@Data
@TableName("sq_house")
@ApiModel(value = "House对象", description = "门户信息")
public class House {

	private static final long serialVersionUID = 1L;

	/**
	* ID
	*/
		@ApiModelProperty(value = "ID")
		private String id;
	/**
	* 房屋编号
	*/
		@ApiModelProperty(value = "房屋编号")
		private String fwBh;
	/**
	* 房屋代码
	*/
		@ApiModelProperty(value = "房屋代码")
		private String fwDm;
	/**
	* 房屋标识
	*/
		@ApiModelProperty(value = "房屋标识")
		private String fwBs;
	/**
	* 房屋_状态
	*/
		@ApiModelProperty(value = "房屋_状态")
		private String fwZt;
	/**
	* 房屋_类型
	*/
		@ApiModelProperty(value = "房屋_类型")
		private String fwLx;
	/**
	* 房屋地址名称
	*/
		@ApiModelProperty(value = "房屋地址名称")
		private String fangwuDzmc;
	/**
	* 建筑面积_面积（平方米）
	*/
		@ApiModelProperty(value = "建筑面积_面积（平方米）")
		private Double jzmjMjpfm;
	/**
	* 所在楼层号
	*/
		@ApiModelProperty(value = "所在楼层号")
		private String szLch;
	/**
	* 房屋用途_简要情况
	*/
		@ApiModelProperty(value = "房屋用途_简要情况")
		private String fwytJyqk;
	/**
	* 居住人数数量
	*/
		@ApiModelProperty(value = "居住人数数量")
		private String jzrySl;
	/**
	* 委托代理人姓名
	*/
		@ApiModelProperty(value = "委托代理人姓名")
		private String wtdlrXm;
	/**
	* 委托代理人证件类型名称
	*/
		@ApiModelProperty(value = "委托代理人证件类型名称")
		private String wtdlrZjlxmc;
	/**
	* 委托代理人证件号码
	*/
		@ApiModelProperty(value = "委托代理人证件号码")
		private String wtdlrZjhm;
	/**
	* 委托代理人联系电话
	*/
		@ApiModelProperty(value = "委托代理人联系电话")
		private String wtdlrLxdh;
	/**
	* 所有权类型
	*/
		@ApiModelProperty(value = "所有权类型")
		private String syqLx;
	/**
	* 重点房屋判断标识
	*/
		@ApiModelProperty(value = "重点房屋判断标识")
		private String zdfwPdbs;
	/**
	* 租赁_状态
	*/
		@ApiModelProperty(value = "租赁_状态")
		private String zlZt;
	/**
	* 居住住宅_判断标识
	*/
		@ApiModelProperty(value = "居住住宅_判断标识")
		private String jzzzPdbs;
	/**
	* 入住日期时间
	*/
		@ApiModelProperty(value = "入住日期时间")
		private LocalDateTime rzRqsj;
	/**
	* 过期日期时间
	*/
		@ApiModelProperty(value = "过期日期时间")
		private LocalDateTime gqRqsj;
	/**
	* 单位ID
	*/
		@ApiModelProperty(value = "单位ID")
		private String unitId;
	/**
	* 楼栋ID
	*/
		@ApiModelProperty(value = "楼栋ID")
		private String buildingId;
	/**
	* 社区ID
	*/
		@ApiModelProperty(value = "社区ID")
		private String communityId;
	/**
	* 房间ID（社区民警提供）
	*/
		@ApiModelProperty(value = "房间ID（社区民警提供）")
		@TableField("fjId")
	private String fjId;


}
