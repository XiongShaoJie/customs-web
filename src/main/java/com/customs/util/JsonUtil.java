package com.customs.util;

import java.io.IOException;

import com.customs.entity.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON工具类
 * 
 * @author dell
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 实体转字符串
     * 
     * @param object
     * @return
     */
    public static String obj2JsonString(Object object) {
	String s = null;
	try {
	    s = objectMapper.writeValueAsString(object);
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	}
	return s;
    }

    /**
     * 字符串转实体
     * 
     * @param s
     * @param clazz
     * @return
     */
    public static <T> T jsonString2Obj(String s, Class<T> clazz) {
	T t = null;
	try {
	    t = objectMapper.readValue(s, clazz);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return t;
    }

}
