package com.layui.dao.service;

import com.layui.dao.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhulin
 * @since 2019-03-21
 */
public interface IUserService extends IService<User> {

	IPage<User> selectPage(Page<User> page, String userName);
	
	void addUser(User user);
	
}
