package com.customs.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis配置（可多个redis）
 * 
 * @author dell
 */
@Configuration
public class RedisConfiguration {

	/**
	 * 设置序列化方式
	 * 
	 * @param template
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setSerializer(RedisTemplate template) {
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setValueSerializer(jackson2JsonRedisSerializer);
	}

	/**
	 * 创建redis连接工厂
	 * 
	 * @param hostName
	 * @param port
	 * @param password
	 * @param maxIdle
	 * @param maxTotal
	 * @param index
	 * @param maxWaitMillis
	 * @param testOnBorrow
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public RedisConnectionFactory connectionFactory(String hostName, String userName, int port, String password,
			int maxIdle, int maxTotal, int index, long maxWaitMillis, int timeOut) {
		JedisConnectionFactory jedis = new JedisConnectionFactory();
		jedis.setHostName(hostName);
		jedis.setPort(port);
		jedis.setPassword(password);
		JedisPoolConfig jedisPoolConfig = poolCofig(maxIdle, maxTotal, maxWaitMillis);
		jedis.setPoolConfig(jedisPoolConfig);
		jedis.setTimeout(timeOut);
		// 初始化连接pool
		jedis.afterPropertiesSet();
		RedisConnectionFactory factory = jedis;
		return factory;
	}

	/**
	 * JedisPoolConfig配置
	 * 
	 * @param maxIdle
	 * @param maxTotal
	 * @param maxWaitMillis
	 * @param testOnBorrow
	 * @return
	 */
	public JedisPoolConfig poolCofig(int maxIdle, int maxTotal, long maxWaitMillis) {
		JedisPoolConfig poolCofig = new JedisPoolConfig();
		poolCofig.setMaxIdle(maxIdle);
		poolCofig.setMaxTotal(maxTotal);
		poolCofig.setMaxWaitMillis(maxWaitMillis);
		return poolCofig;
	}
}
