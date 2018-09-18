package com.customs.configuration;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 数据源配置，两种方式，1.Environment类，2.@Value读取
 * @author dell
 */
@Configuration
@MapperScan("com.customs.dao.mapper")
public class DataSourceConfiguration {
	@Value("${jdbc.url.slave}")
	private String jdbcUrl;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.driver}")
	private String driver;

	@Bean(name = "dataSourceMaster")
	public DataSource createDataSourceMaster(Environment env) {
		DruidDataSource dataSource = new DruidDataSource();
		String url = env.getProperty("jdbc.url.master");
		String username = env.getProperty("jdbc.username");
		String password = env.getProperty("jdbc.password");
		String driver = env.getProperty("jdbc.driver");
		String initalSize = env.getProperty("jdbc.initalSize");
		String minIdle = env.getProperty("jdbc.minIdle");
		String maxActive = env.getProperty("jdbc.maxActive");
		String maxWait = env.getProperty("jdbc.maxWait");
		String term = env.getProperty("jdbc.timeBetweenEvictionRunsMillis");
		dataSource.setUrl(url);
		dataSource.setPassword(password);
		dataSource.setUsername(username);
		dataSource.setDriverClassName(driver);
		dataSource.setInitialSize(Integer.valueOf(initalSize));
		dataSource.setMaxActive(Integer.valueOf(maxActive));
		dataSource.setMaxWait(Long.valueOf(maxWait));
		dataSource.setMinIdle(Integer.valueOf(minIdle));
		dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(term));
		return dataSource;
	}

	@Bean(name = "dataSourceSlave")
	public DataSource createDataSourceSlave() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(jdbcUrl);
		dataSource.setPassword(password);
		dataSource.setUsername(username);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}

}
