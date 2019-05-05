package com.layui.dao;

import com.layui.dao.entity.Ldcode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LdcodeTest {

	@Test
	public void test() {
		log.info("测试结果:111");
		Ldcode ldcode = new Ldcode();
		ldcode.setCodetype("aaa");
		ldcode.setCode("1");
		log.info("测试结果:" + ldcode.toString());
	}

}
