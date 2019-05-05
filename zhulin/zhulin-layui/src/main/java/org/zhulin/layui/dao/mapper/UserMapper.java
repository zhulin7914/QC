package org.zhulin.layui.dao.mapper;

import org.zhulin.layui.dao.entity.User;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhulin
 * @since 2019-03-21
 */
public interface UserMapper extends BaseMapper<User> {//可以继承或者不继承BaseMapper
    /**
     * <p>
     * 查询 : 根据userName查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param userName 用户名
     * @return 分页对象
     */
    IPage<User> selectPageVo(Page page, @Param("userName") String userName);

}
