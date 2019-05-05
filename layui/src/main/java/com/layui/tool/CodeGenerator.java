package com.layui.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * mybatis-plus 的代码生成器
 * 执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 */
public class CodeGenerator {

	/**
	 * <p>
	 * 读取控制台内容
	 * </p>
	 */
	public static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}

	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java"); // 设置文件输出路径
		gc.setAuthor("zhulin");
		gc.setOpen(false);
		gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
//Oracle数据库
//		dsc.setUrl("jdbc:oracle:thin:@10.8.200.161:1521:ghisdev");
//		dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
//		dsc.setUsername("slisbase");
//		dsc.setPassword("opv#QV235T8");
//		dsc.setUsername("slisdata");
//		dsc.setPassword("OP#uyiobT123");
//		dsc.setUsername("slisoper");
//		dsc.setPassword("YU##h67YUO3");
// mysql数据库		
//		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&useSSL=true&allowMultiQueries=true&serverTimezone=Asia/Hong_Kong");
////		dsc.setDriverName("com.mysql.cj.jdbc.Driver"); //这个是spring boot 2.1之后版本用的驱动
//		dsc.setDriverName("com.mysql.jdbc.Driver");
//		dsc.setUsername("root");
//		dsc.setPassword("root");
// mycat-分库-db1	
		dsc.setUrl("jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=UTF8&zeroDateTimeBehavior=convertToNull&useSSL=true&allowMultiQueries=true&serverTimezone=Asia/Hong_Kong");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("root");		
		
		mpg.setDataSource(dsc);

		 // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.layui");// 父包名
        mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};

		// 如果模板引擎是 freemarker
		String templatePath = "/templates/mapper.xml.ftl";
		// 如果模板引擎是 velocity
		// String templatePath = "/templates/mapper.xml.vm";

		// 自定义输出配置
		List<FileOutConfig> focList = new ArrayList<>();
		// 自定义配置会被优先输出
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/src/main/java/com/layui/" + pc.getModuleName() + "/xml/"
						+ tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});

		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);

		// 配置模板
		TemplateConfig templateConfig = new TemplateConfig();

		// 配置自定义输出模板
		// 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
		// templateConfig.setEntity("templates/entity2.java");
		// templateConfig.setService();
		// templateConfig.setController();

		templateConfig.setXml(null);
		mpg.setTemplate(templateConfig);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//		strategy.setSuperEntityClass("com.layui.dao.common.BaseEntity"); //自定义继承的Entity类全称，带包名
		strategy.setEntityLombokModel(true);
		strategy.setRestControllerStyle(true);
//		strategy.setSuperControllerClass("com.layui.dao.common.BaseController");//自定义继承的Controller类全称，带包名
		strategy.setInclude(scanner("表名"));
		strategy.setSuperEntityColumns("id");
		strategy.setControllerMappingHyphenStyle(true);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}

}