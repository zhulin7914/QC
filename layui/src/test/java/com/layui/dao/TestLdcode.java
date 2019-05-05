package com.layui.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.layui.dao.entity.Ldcode;
import com.layui.dao.mapper.LdcodeMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestLdcode {

	@Resource
	private LdcodeMapper ldcodeMapper;
	
	@Test
	  public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Ldcode> userList = ldcodeMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        log.info("测试结果:" + userList.size());
       // userList.forEach(System.out::println);
    }
}
