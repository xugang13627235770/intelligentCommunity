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
package cn.citms.icw.service.impl;

import cn.citms.icw.entity.CommunityDevice;
import cn.citms.icw.vo.CommunityDeviceVO;
import cn.citms.icw.mapper.CommunityDeviceMapper;
import cn.citms.icw.service.ICommunityDeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.core.mp.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * 社区设备关联表 服务实现类
 *
 * @author Blade
 * @since 2020-04-22
 */
@Service
public class CommunityDeviceServiceImpl extends ServiceImpl<CommunityDeviceMapper, CommunityDevice> implements ICommunityDeviceService {

	@Override
	public IPage<CommunityDeviceVO> selectCommunityDevicePage(IPage<CommunityDeviceVO> page, CommunityDeviceVO communityDevice) {
		return page.setRecords(baseMapper.selectCommunityDevicePage(page, communityDevice));
	}

}
