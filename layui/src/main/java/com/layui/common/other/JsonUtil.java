package com.layui.common.other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
* <p>Title: JsonUtil</p>  
* <p>Description: json公共类</p>  
* @author zhulin
* @date 2019年4月17日
 */
public final class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    /**
     * 序列化，将值转换成Strng类型
     */
    public static String generate(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    /**
     * 反序列化，将String类型装换成指定类型
     */
    public static <T> T parse(String content, Class<T> valueType) throws IOException {
        return mapper.readValue(content, valueType);
    }
}
