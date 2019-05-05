package com.layui.dao.service;

import com.layui.dao.entity.Lead;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhulin
 * @since 2019-04-23
 */
public interface ILeadService extends IService<Lead> {

	void insert(Lead lead);

	List<Lead> selectAll();

}
