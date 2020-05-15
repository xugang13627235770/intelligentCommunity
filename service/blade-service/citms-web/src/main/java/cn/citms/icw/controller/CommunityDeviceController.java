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
package cn.citms.icw.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.citms.icw.entity.CommunityDevice;
import cn.citms.icw.vo.CommunityDeviceVO;
import cn.citms.icw.wrapper.CommunityDeviceWrapper;
import cn.citms.icw.service.ICommunityDeviceService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 社区设备关联表 控制器
 *
 * @author Blade
 * @since 2020-04-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("icw/communitydevice")
@Api(value = "社区设备关联表", tags = "社区设备关联表接口")
public class CommunityDeviceController extends BladeController {

	private ICommunityDeviceService communityDeviceService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入communityDevice")
	public R<CommunityDeviceVO> detail(CommunityDevice communityDevice) {
		CommunityDevice detail = communityDeviceService.getOne(Condition.getQueryWrapper(communityDevice));
		return R.data(CommunityDeviceWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 社区设备关联表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入communityDevice")
	public R<IPage<CommunityDeviceVO>> list(CommunityDevice communityDevice, Query query) {
		IPage<CommunityDevice> pages = communityDeviceService.page(Condition.getPage(query), Condition.getQueryWrapper(communityDevice));
		return R.data(CommunityDeviceWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 社区设备关联表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入communityDevice")
	public R<IPage<CommunityDeviceVO>> page(CommunityDeviceVO communityDevice, Query query) {
		IPage<CommunityDeviceVO> pages = communityDeviceService.selectCommunityDevicePage(Condition.getPage(query), communityDevice);
		return R.data(pages);
	}

	/**
	 * 新增 社区设备关联表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入communityDevice")
	public R save(@Valid @RequestBody CommunityDevice communityDevice) {
		return R.status(communityDeviceService.save(communityDevice));
	}

	/**
	 * 修改 社区设备关联表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入communityDevice")
	public R update(@Valid @RequestBody CommunityDevice communityDevice) {
		return R.status(communityDeviceService.updateById(communityDevice));
	}

	/**
	 * 新增或修改 社区设备关联表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入communityDevice")
	public R submit(@Valid @RequestBody CommunityDevice communityDevice) {
		return R.status(communityDeviceService.saveOrUpdate(communityDevice));
	}

	
	/**
	 * 删除 社区设备关联表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(true);
	}

	
}
