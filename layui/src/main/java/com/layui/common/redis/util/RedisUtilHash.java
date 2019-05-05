package com.layui.common.redis.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <p>
 * Title: RedisUtilHash
 * </p>
 * <p>
 * Description:Redis hash公共处理方法
 * </p>
 * 
 * @author zhulin
 * @date 2019年4月18日
 */
@Component
public class RedisUtilHash {

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 获取hash中field对应的值
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public String hget(String key, String field) {
		Object val = redisTemplate.opsForHash().get(key, field);
		return val == null ? null : val.toString();
	}

	/**
	 * 添加or更新hash的值
	 * 
	 * @param key
	 * @param field
	 * @param value
	 */
	public void hset(String key, String field, String value) {
		redisTemplate.opsForHash().put(key, field, value);
	}

	/**
	 * hash 结构的计数
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public long hincr(String key, String field, long value) {
		return redisTemplate.opsForHash().increment(key, field, value);
	}

	/**
	 * 删除hash
	 * 
	 * @param key
	 */
	public void hdel(String key) {
		redisTemplate.opsForHash().delete(key);
	}

	/**
	 * 删除hash中field这一对kv
	 * 
	 * @param key
	 * @param field
	 */
	public void hdel(String key, String field) {
		redisTemplate.opsForHash().delete(key, field);
	}

	/**
	 * 根据key获取全部数据
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> hgetall(String key) {
		Map<String, String> stumap=redisTemplate.boundHashOps(key).entries();
		return stumap;
	}

	/**
	 * 获取指定key的相关数据
	 * 
	 * @param key
	 * @param fields
	 * @return
	 */
	public Map<String, String> hmget(String key, List<String> fields) {
		List<String> result = redisTemplate.<String, String>opsForHash().multiGet(key, fields);
		Map<String, String> ans = new HashMap<>(fields.size());
		int index = 0;
		for (String field : fields) {
			if (result.get(index) == null) {
				continue;
			}
			ans.put(field, result.get(index));
		}
		return ans;
	}

	/**
	 * hash + list，value为list的场景 获取数据
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public <T> List<T> hGetList(String key, String field, Class<T> obj) {
		Object value = redisTemplate.opsForHash().get(key, field);
		if (value != null) {
			return JSONObject.parseArray(value.toString(), obj);
		} else {
			return new ArrayList<>();
		}
	}

	/**
	 * hash + list，value为list的场景 设置数据
	 * 
	 * @param key
	 * @param field
	 * @param values
	 */
	public <T> void hSetList(String key, String field, List<T> values) {
		String v = JSONObject.toJSONString(values);
		redisTemplate.opsForHash().put(key, field, v);
	}

}
