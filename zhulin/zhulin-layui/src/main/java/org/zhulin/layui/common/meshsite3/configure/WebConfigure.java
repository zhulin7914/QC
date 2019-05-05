package org.zhulin.layui.common.meshsite3.configure;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import org.zhulin.layui.common.meshsite3.filter.Meshsite3Filter;

/**
 * 配置文件
 */
@Configuration
public class WebConfigure extends WebMvcConfigurationSupport {
	
	
	String basePath = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath()+ "/files/";
	
	/**
	 * sitemesh 配置
	 */
	@Bean
	public FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean fitler = new FilterRegistrationBean();
		Meshsite3Filter siteMeshFilter = new Meshsite3Filter();
		fitler.setFilter(siteMeshFilter);
		return fitler;
	}

	/**
	 * 静态资源的访问配置
	 * 解决项目打包生成jar后，路径问题
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //当请求Url包含static/files/时，就会以文件路径来访问basePath下面的文件
        registry.addResourceHandler("static/files/**").addResourceLocations("file:" + basePath);
        super.addResourceHandlers(registry);
	}
}