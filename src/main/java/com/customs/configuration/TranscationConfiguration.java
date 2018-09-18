package com.customs.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * 事务管理器配置类
 * 
 * @author dell
 */
@Configuration
public class TranscationConfiguration implements TransactionManagementConfigurer {
	@Qualifier("dataSourceMaster")
	@Autowired
	private DataSource dataSource;

	// 指定事务管理器
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

}
