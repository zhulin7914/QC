package com.layui.common.configure;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.layui.common.cat.CatInterceptor;
import com.layui.common.meshsite3.filter.Meshsite3Filter;

/**
 * 配置文件
 */
@Configuration
public class WebConfigure extends WebMvcConfigurationSupport {

	String basePath = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath() + "/files/";

	/**
	 * sitemesh3 配置
	 */
	@Bean
	public FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean fitler = new FilterRegistrationBean();
		Meshsite3Filter siteMeshFilter = new Meshsite3Filter();
		fitler.setFilter(siteMeshFilter);
		return fitler;
	}
	

	/**
	 * 拦截器配置
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则, 这里假设拦截 /后面的全部链接
        // excludePathPatterns 用于排除拦截
		// 添加cat拦截器
		registry.addInterceptor(new CatInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
	}

	/**
	 * 静态资源的访问配置 解决项目打包生成jar后，路径问题
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		// 当请求Url包含static/files/时，就会以文件路径来访问basePath下面的文件
		registry.addResourceHandler("static/files/**").addResourceLocations("file:" + basePath);
		super.addResourceHandlers(registry);
	}
}