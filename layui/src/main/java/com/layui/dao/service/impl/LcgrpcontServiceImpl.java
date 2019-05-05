package com.layui.dao.service.impl;

import com.layui.dao.entity.Lcgrpcont;
import com.layui.dao.mapper.LcgrpcontMapper;
import com.layui.dao.service.ILcgrpcontService;

import lombok.extern.slf4j.Slf4j;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 团体保单表 服务实现类
 * </p>
 *
 * @author zhulin
 * @since 2019-03-26
 */
@Service
@Slf4j
public class LcgrpcontServiceImpl extends ServiceImpl<LcgrpcontMapper, Lcgrpcont> implements ILcgrpcontService {

	@Resource
	private LcgrpcontMapper lcgrpcontMapper;
	

	@Override
	public Page<Lcgrpcont> selectAllList(Page page) {
	    return lcgrpcontMapper.selectAllList(page);
	}
	
	@Override
	public Long selectAllCount() {
		return lcgrpcontMapper.selectAllCount();
	}

	@Override
	public Page<Lcgrpcont> selectPage(Page page, String grpcontno) {
		log.info(("获取保单号:" + grpcontno));
	    return lcgrpcontMapper.selectPageVo(page, grpcontno);
	}

}
