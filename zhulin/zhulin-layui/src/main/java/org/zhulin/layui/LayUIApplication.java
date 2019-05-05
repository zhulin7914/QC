package org.zhulin.layui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan可以指定要扫描的Mapper类的包的路径
@MapperScan("org.zhulin.layui.dao.mapper")
public class LayUIApplication {

	public static void main(String[] args) {
		SpringApplication.run(LayUIApplication.class, args);
	}

}
