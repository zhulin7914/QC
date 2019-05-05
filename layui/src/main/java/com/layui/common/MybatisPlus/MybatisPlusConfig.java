package com.layui.common.MybatisPlus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.layui.common.cat.CatMybatisPlugins;

@EnableTransactionManagement
@Configuration
@MapperScan("com.layui.*.mapper*")
public class MybatisPlusConfig {

	/**
	 * 分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
	
	/**
	 * 乐观锁插件
	 * 注解实体字段 @Version 必须要!
	 */
	@Bean
	public OptimisticLockerInterceptor optimisticLockerInterceptor() {
	    return new OptimisticLockerInterceptor();
	}
	
	/**
	 * 美团CAT-mybatis拦截器
	 */
	@Bean
	public CatMybatisPlugins catMybatisPlugins() {
		return new CatMybatisPlugins();
	}
	
}
