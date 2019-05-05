package com.layui.dao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.layui.common.other.BasicConfig;
import com.layui.dao.entity.Lcgrpcont;
import com.layui.dao.service.ILcgrpcontService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 团体保单表 前端控制器
 * </p>
 *
 * @author zhulin
 * @since 2019-03-26
 */
@RestController
@Slf4j
@RequestMapping("/dao/lcgrpcont")                                                                                                                                 
public class LcgrpcontController {
	
	@Autowired
	private ILcgrpcontService lcgrpcontService;

	/**
	 * 查询所有保单
	 */
	@RequestMapping(value = "/all")
	@ResponseBody
	public Map<String, Object> all(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit) {
		log.info("page: " + page + "  limit：" + limit);
		Page<Lcgrpcont> lcgrpconts = lcgrpcontService.selectAllList(new Page<>(page, limit));
		Long count = lcgrpcontService.selectAllCount();
		return BasicConfig.getTableMap(count, lcgrpconts);
	}

	/**
	 * 根据保单号查询保单
	 */
	@RequestMapping(value = "/show")
	@ResponseBody
	public Map<String, Object> show(@RequestParam(value = "page") int page, @RequestParam(value = "limit") int limit,
			@RequestParam(value = "grpcontno") String grpcontno) {
		log.info("page: " + page + "  limit：" + limit);
		Page<Lcgrpcont> lcgrpconts = lcgrpcontService.selectPage(new Page<>(page, limit), grpcontno);
		return BasicConfig.getTableMap((long) lcgrpconts.getRecords().size(), lcgrpconts);
	}

}
