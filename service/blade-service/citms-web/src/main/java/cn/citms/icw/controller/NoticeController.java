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
import cn.citms.icw.entity.Notice;
import cn.citms.icw.vo.NoticeVO;
import cn.citms.icw.wrapper.NoticeWrapper;
import cn.citms.icw.service.INoticeService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 * 通知公告表 控制器
 *
 * @author Blade
 * @since 2020-04-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("icw/notice")
@Api(value = "通知公告表", tags = "通知公告表接口")
public class NoticeController extends BladeController {

	private INoticeService noticeService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入notice")
	public R<NoticeVO> detail(Notice notice) {
		Notice detail = noticeService.getOne(Condition.getQueryWrapper(notice));
		return R.data(NoticeWrapper.build().entityVO(detail));
	}

	/**
	 * 分页 通知公告表
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入notice")
	public R<IPage<NoticeVO>> list(Notice notice, Query query) {
		IPage<Notice> pages = noticeService.page(Condition.getPage(query), Condition.getQueryWrapper(notice));
		return R.data(NoticeWrapper.build().pageVO(pages));
	}


	/**
	 * 自定义分页 通知公告表
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入notice")
	public R<IPage<NoticeVO>> page(NoticeVO notice, Query query) {
		IPage<NoticeVO> pages = noticeService.selectNoticePage(Condition.getPage(query), notice);
		return R.data(pages);
	}

	/**
	 * 新增 通知公告表
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入notice")
	public R save(@Valid @RequestBody Notice notice) {
		return R.status(noticeService.save(notice));
	}

	/**
	 * 修改 通知公告表
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入notice")
	public R update(@Valid @RequestBody Notice notice) {
		return R.status(noticeService.updateById(notice));
	}

	/**
	 * 新增或修改 通知公告表
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入notice")
	public R submit(@Valid @RequestBody Notice notice) {
		return R.status(noticeService.saveOrUpdate(notice));
	}

	
	/**
	 * 删除 通知公告表
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 7)
	@ApiOperation(value = "逻辑删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(true);
	}

	
}
