package com.layui.dao.mapper;

import com.layui.dao.entity.Lcgrpcont;
import com.layui.dao.entity.User;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 团体保单表 Mapper 接口
 * </p>
 *
 * @author zhulin
 * @since 2019-03-26
 */
public interface LcgrpcontMapper extends BaseMapper<Lcgrpcont> {
	
	/**
	 * 查询所有保单
	 */
	Page<Lcgrpcont> selectAllList(Page page);
	
	/**
	 * 查询所有保单总数
	 */
	Long selectAllCount();
	
	/**
	 * 查询保单
	 */
	Page<Lcgrpcont> selectPageVo(Page page, @Param("grpcontno") String grpcontno);

}
