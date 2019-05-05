package com.layui.dao.service;

import com.layui.dao.entity.Lcgrpcont;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 团体保单表 服务类
 * </p>
 *
 * @author zhulin
 * @since 2019-03-26
 */
public interface ILcgrpcontService extends IService<Lcgrpcont> {
	
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
	Page<Lcgrpcont> selectPage(Page page, String grpcontno);

}
