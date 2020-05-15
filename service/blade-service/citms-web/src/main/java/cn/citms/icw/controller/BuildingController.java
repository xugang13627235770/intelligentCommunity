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
import cn.citms.icw.entity.Building;
import cn.citms.icw.vo.BuildingVO;
import cn.citms.icw.wrapper.BuildingWrapper;
import cn.citms.icw.service.IBuildingService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 楼栋信息 控制器
 *
 * @author Blade
 * @since 2020-04-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("icw/building")
@Api(value = "楼栋信息", tags = "楼栋信息接口")
public class BuildingController extends BladeController {

	private IBuildingService buildingService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入building")
	public R<BuildingVO> detail(Building building) {
		Building detail = buildingService.getOne(Condition.getQueryWrapper(building));
		return R.data(BuildingWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 楼栋信息
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入building")
	public R<IPage<BuildingVO>> list(Building building, Query query) {
		IPage<Building> pages = buildingService.page(Condition.getPage(query), Condition.getQueryWrapper(building));
		return R.data(BuildingWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 楼栋信息
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入building")
	public R<IPage<BuildingVO>> page(BuildingVO building, Query query) {
		IPage<BuildingVO> pages = buildingService.selectBuildingPage(Condition.getPage(query), building);
		return R.data(pages);
	}

	/**
	 * 新增 楼栋信息
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入building")
	public R save(@Valid @RequestBody Building building) {
		return R.status(buildingService.save(building));
	}

	/**
	 * 修改 楼栋信息
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入building")
	public R update(@Valid @RequestBody Building building) {
		return R.status(buildingService.updateById(building));
	}

	/**
	 * 新增或修改 楼栋信息
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入building")
	public R submit(@Valid @RequestBody Building building) {
		return R.status(buildingService.saveOrUpdate(building));
	}

	
	/**
	 * 删除 楼栋信息
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(true);
	}

	
}
