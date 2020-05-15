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
import cn.citms.icw.entity.House;
import cn.citms.icw.vo.HouseVO;
import cn.citms.icw.wrapper.HouseWrapper;
import cn.citms.icw.service.IHouseService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 门户信息 控制器
 *
 * @author Blade
 * @since 2020-04-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("icw/house")
@Api(value = "门户信息", tags = "门户信息接口")
public class HouseController extends BladeController {

	private IHouseService houseService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入house")
	public R<HouseVO> detail(House house) {
		House detail = houseService.getOne(Condition.getQueryWrapper(house));
		return R.data(HouseWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 门户信息
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入house")
	public R<IPage<HouseVO>> list(House house, Query query) {
		IPage<House> pages = houseService.page(Condition.getPage(query), Condition.getQueryWrapper(house));
		return R.data(HouseWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 门户信息
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入house")
	public R<IPage<HouseVO>> page(HouseVO house, Query query) {
		IPage<HouseVO> pages = houseService.selectHousePage(Condition.getPage(query), house);
		return R.data(pages);
	}

	/**
	 * 新增 门户信息
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入house")
	public R save(@Valid @RequestBody House house) {
		return R.status(houseService.save(house));
	}

	/**
	 * 修改 门户信息
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入house")
	public R update(@Valid @RequestBody House house) {
		return R.status(houseService.updateById(house));
	}

	/**
	 * 新增或修改 门户信息
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入house")
	public R submit(@Valid @RequestBody House house) {
		return R.status(houseService.saveOrUpdate(house));
	}

	
	/**
	 * 删除 门户信息
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(true);
	}

	
}
