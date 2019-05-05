package com.layui.dao.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.layui.dao.entity.Lead;
import com.layui.dao.service.ILeadService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhulin
 * @since 2019-04-23
 */
@RestController
@Slf4j
@RequestMapping("/dao/lead")
public class LeadController {
		
	@Autowired
	private ILeadService leadService;
	
	@RequestMapping("/save")
    public String save(Lead lead){
		log.info("开始保存！");
		try {
			leadService.insert(lead);
		}catch(Exception e) {
            return "保存失败，发生异常";
		}
		log.info("保存成功！");
        return "保存成功";
    }
	
    @RequestMapping("/list")
    public List<Lead> list(){
    	log.info("查询");
        return leadService.selectAll();
    }
	
}
