package org.zhulin.layui.common.meshsite3.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * sitemesh 自定义拦截配置
 */
public class Meshsite3Filter extends ConfigurableSiteMeshFilter {
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/layout/main")// 拦截规则，/layout/main会被转发
				.addExcludedPath("/static/**") // 白名单
				.addExcludedPath("/druid/**") // 白名单
		// .addTagRuleBundle(new MyTagRuleBundle())// 自定义标签
		;
	}
}