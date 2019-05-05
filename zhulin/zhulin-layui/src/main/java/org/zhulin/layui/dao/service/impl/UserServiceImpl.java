package org.zhulin.layui.dao.service.impl;

import org.zhulin.layui.dao.entity.User;
import org.zhulin.layui.dao.mapper.UserMapper;
import org.zhulin.layui.dao.service.IUserService;

import lombok.extern.slf4j.Slf4j;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhulin
 * @since 2019-03-21
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
	@Resource
	private UserMapper userMapper;
	
	@Override
	public IPage<User> selectPage(Page<User> page, String userName) {
	    // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
	    // page.setOptimizeCountSql(false);
	    // 当 total 为非 0 时(默认为 0),分页插件不会进行 count 查询
	    // 要点!! 分页返回的对象与传入的对象是同一个
		log.info(("测试结果:" + userName));
	    return userMapper.selectPageVo(page, userName);
	}
}


