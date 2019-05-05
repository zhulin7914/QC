package com.layui.dao.service.impl;

import com.layui.dao.entity.Lead;
import com.layui.dao.mapper.LeadMapper;
import com.layui.dao.service.ILeadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhulin
 * @since 2019-04-23
 */
@Service
public class LeadServiceImpl extends ServiceImpl<LeadMapper, Lead> implements ILeadService {

	@Resource
	private LeadMapper leadMapper;

	@Override
	//开启事务，自动提交，手动回滚
	@Transactional(rollbackFor = { Exception.class })
	public void insert(Lead lead)  {
		try {
			leadMapper.insert(lead);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<Lead> selectAll() {
		return leadMapper.selectAll();
	}

}
