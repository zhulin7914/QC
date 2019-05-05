package com.layui.common.other;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * Title: BasicConfig
 * </p>
 * <p>
 * Description: 提供一些自定义的公共配置
 * </p>
 * 
 * @author zhulin
 * @date 2019年3月27日
 */
public final class BasicConfig {

	/**
	 * <p>
	 * Title: getTableMap
	 * </p>
	 * <p>
	 * Description: 返回表格数据格式
	 * </p>
	 * 
	 * @author zuhlin
	 * @date 2019年3月27日
	 * @param count：数据长度
	 * @param page：分页记录列表
	 * @return
	 */
	public static Map<String, Object> getTableMap(Long count, Page page) {
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("code", 0); // 接口状态
		map.put("msg", ""); // 提示文本
		map.put("count", count); // 数据长度
		map.put("data", page.getRecords()); // 数据列表
		return map;
	}

}
