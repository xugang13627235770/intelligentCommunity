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
import cn.citms.icw.entity.Patrolpoint;
import cn.citms.icw.vo.PatrolpointVO;
import cn.citms.icw.wrapper.PatrolpointWrapper;
import cn.citms.icw.service.IPatrolpointService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 *  控制器
 *
 * @author Blade
 * @since 2020-04-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("icw/patrolpoint")
@Api(value = "", tags = "接口")
public class PatrolpointController extends BladeController {

	private IPatrolpointService patrolpointService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入patrolpoint")
	public R<PatrolpointVO> detail(Patrolpoint patrolpoint) {
		Patrolpoint detail = patrolpointService.getOne(Condition.getQueryWrapper(patrolpoint));
		return R.data(PatrolpointWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入patrolpoint")
	public R<IPage<PatrolpointVO>> list(Patrolpoint patrolpoint, Query query) {
		IPage<Patrolpoint> pages = patrolpointService.page(Condition.getPage(query), Condition.getQueryWrapper(patrolpoint));
		return R.data(PatrolpointWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入patrolpoint")
	public R<IPage<PatrolpointVO>> page(PatrolpointVO patrolpoint, Query query) {
		IPage<PatrolpointVO> pages = patrolpointService.selectPatrolpointPage(Condition.getPage(query), patrolpoint);
		return R.data(pages);
	}

	/**
	 * 新增 
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入patrolpoint")
	public R save(@Valid @RequestBody Patrolpoint patrolpoint) {
		return R.status(patrolpointService.save(patrolpoint));
	}

	/**
	 * 修改 
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入patrolpoint")
	public R update(@Valid @RequestBody Patrolpoint patrolpoint) {
		return R.status(patrolpointService.updateById(patrolpoint));
	}

	/**
	 * 新增或修改 
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入patrolpoint")
	public R submit(@Valid @RequestBody Patrolpoint patrolpoint) {
		return R.status(patrolpointService.saveOrUpdate(patrolpoint));
	}

	
	/**
	 * 删除 
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(true);
	}

	
}
