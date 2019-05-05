package org.zhulin.apollo.common.apollo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

//统一管理application配置的bean
//注意@EnableApolloConfig要和@Configuration一起使用，不然不会生效。
@Configuration
@EnableApolloConfig  //注入namespace的配置到Spring中

//这个是稍微复杂一些的配置形式，指示Apollo注入FX.apollo和application.yml namespace的配置到Spring环境中
//@EnableApolloConfig({"FX.apollo", "application.yml"}) 

//这个是最复杂的配置形式，指示Apollo注入FX.apollo和application.yml namespace的配置到Spring环境中，并且order指定顺序
//@EnableApolloConfig(value = {"FX.apollo", "application.yml"}, order = 1)
public class ApollpConfig {
	@Bean
	public TestJavaConfigBean javaConfigBean() {
		return new TestJavaConfigBean();
	}
}
