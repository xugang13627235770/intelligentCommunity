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
import cn.citms.icw.entity.Personcheckin;
import cn.citms.icw.vo.PersoncheckinVO;
import cn.citms.icw.wrapper.PersoncheckinWrapper;
import cn.citms.icw.service.IPersoncheckinService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 住户信息 控制器
 *
 * @author Blade
 * @since 2020-04-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("icw/personcheckin")
@Api(value = "住户信息", tags = "住户信息接口")
public class PersoncheckinController extends BladeController {

	private IPersoncheckinService personcheckinService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入personcheckin")
	public R<PersoncheckinVO> detail(Personcheckin personcheckin) {
		Personcheckin detail = personcheckinService.getOne(Condition.getQueryWrapper(personcheckin));
		return R.data(PersoncheckinWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 住户信息
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入personcheckin")
	public R<IPage<PersoncheckinVO>> list(Personcheckin personcheckin, Query query) {
		IPage<Personcheckin> pages = personcheckinService.page(Condition.getPage(query), Condition.getQueryWrapper(personcheckin));
		return R.data(PersoncheckinWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 住户信息
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入personcheckin")
	public R<IPage<PersoncheckinVO>> page(PersoncheckinVO personcheckin, Query query) {
		IPage<PersoncheckinVO> pages = personcheckinService.selectPersoncheckinPage(Condition.getPage(query), personcheckin);
		return R.data(pages);
	}

	/**
	 * 新增 住户信息
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入personcheckin")
	public R save(@Valid @RequestBody Personcheckin personcheckin) {
		return R.status(personcheckinService.save(personcheckin));
	}

	/**
	 * 修改 住户信息
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入personcheckin")
	public R update(@Valid @RequestBody Personcheckin personcheckin) {
		return R.status(personcheckinService.updateById(personcheckin));
	}

	/**
	 * 新增或修改 住户信息
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入personcheckin")
	public R submit(@Valid @RequestBody Personcheckin personcheckin) {
		return R.status(personcheckinService.saveOrUpdate(personcheckin));
	}

	
	/**
	 * 删除 住户信息
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(true);
	}

	
}
