package com.customs.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
//配置前缀，setter,getter
@ConfigurationProperties(prefix = "spring.redis")
public class RedisExampleFirst extends RedisConfiguration {
    private String host;
    private String auth;
    private int port;
    private String password;
    private int maxIdle;
    private int maxActive;
    private int index;
    private long maxWait;
    private int timeout;

    @Bean("redisTemplate")
    public StringRedisTemplate createTemplate() {
	StringRedisTemplate template = new StringRedisTemplate();
	RedisConnectionFactory factory = connectionFactory(host, auth, port, password, maxIdle, maxActive, index,
		maxWait, timeout);
	template.setConnectionFactory(factory);
	setSerializer(template);
	template.afterPropertiesSet();
	return template;
    }

    public String getHost() {
	return host;
    }

    public void setHost(String host) {
	this.host = host;
    }

    public String getAuth() {
	return auth;
    }

    public void setAuth(String auth) {
	this.auth = auth;
    }

    public int getPort() {
	return port;
    }

    public void setPort(int port) {
	this.port = port;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public int getMaxIdle() {
	return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
	this.maxIdle = maxIdle;
    }

    public int getMaxActive() {
	return maxActive;
    }

    public void setMaxActive(int maxActive) {
	this.maxActive = maxActive;
    }

    public int getIndex() {
	return index;
    }

    public void setIndex(int index) {
	this.index = index;
    }

    public long getMaxWait() {
	return maxWait;
    }

    public void setMaxWait(long maxWait) {
	this.maxWait = maxWait;
    }

    public int getTimeout() {
	return timeout;
    }

    public void setTimeout(int timeout) {
	this.timeout = timeout;
    }

}
