package com.layui.dao.mapper;

import com.layui.dao.entity.Lead;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhulin
 * @since 2019-04-23
 */
public interface LeadMapper extends BaseMapper<Lead> {

	List<Lead> selectAll();

}
