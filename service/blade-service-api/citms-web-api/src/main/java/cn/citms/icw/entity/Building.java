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
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 楼栋信息实体类
 *
 * @author Blade
 * @since 2020-04-22
 */
@Data
@TableName("sq_building")
@ApiModel(value = "Building对象", description = "楼栋信息")
public class Building  {

	private static final long serialVersionUID = 1L;

	/**
	* ID
	*/
		@ApiModelProperty(value = "ID")
		private String id;
	/**
	* 建筑代码ID
	*/
		@ApiModelProperty(value = "建筑代码ID")
		private String jzdmId;
	/**
	* 建筑编码
	*/
		@ApiModelProperty(value = "建筑编码")
		private String jzBm;
	/**
	* 建筑物名称
	*/
		@ApiModelProperty(value = "建筑物名称")
		private String jzwmc;
	/**
	* 门户数量
	*/
		@ApiModelProperty(value = "门户数量")
		private String mhSl;
	/**
	* 楼栋号名称
	*/
		@ApiModelProperty(value = "楼栋号名称")
		private String ldhMc;
	/**
	* 楼栋标识
	*/
		@ApiModelProperty(value = "楼栋标识")
		private String ldBs;
	/**
	* 建筑性质
	*/
		@ApiModelProperty(value = "建筑性质")
		private String jzXz;
	/**
	* 修建日期时间
	*/
		@ApiModelProperty(value = "修建日期时间")
		private LocalDateTime xjRqsj;
	/**
	* 住宅单元数量
	*/
		@ApiModelProperty(value = "住宅单元数量")
		private String zzdySl;
	/**
	* 地面层数
	*/
		@ApiModelProperty(value = "地面层数")
		private Integer dmCs;
	/**
	* 地下层数
	*/
		@ApiModelProperty(value = "地下层数")
		private Integer dxCs;
	/**
	* 面积（平方米）
	*/
		@ApiModelProperty(value = "面积（平方米）")
		private Double mjpfm;
	/**
	* 排序编号
	*/
		@ApiModelProperty(value = "排序编号")
		private String pxBh;
	/**
	* 扫码入住实施有效期
	*/
		@ApiModelProperty(value = "扫码入住实施有效期")
		private String smrzssYxq;
	/**
	* 地下层居住层数
	*/
		@ApiModelProperty(value = "地下层居住层数")
		private Double dxcjzCs;
	/**
	* 创建时间
	*/
		@ApiModelProperty(value = "创建时间")
		private LocalDateTime cjsj;
	/**
	* 更新时间
	*/
		@ApiModelProperty(value = "更新时间")
		private LocalDateTime gxsj;
	/**
	* 经度纬度详细情况
	*/
		@ApiModelProperty(value = "经度纬度详细情况")
		private String jdwdXxqk;
	/**
	* 社区代码ID
	*/
		@ApiModelProperty(value = "社区代码ID")
		private String communityId;
	/**
	* 地球经度
	*/
		@ApiModelProperty(value = "地球经度")
		private Double dqjd;
	/**
	* 地球纬度
	*/
		@ApiModelProperty(value = "地球纬度")
		private Double dqwd;


}
