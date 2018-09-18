package com.customs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启自动配置
@EnableAutoConfiguration
//开启定时任务
@EnableScheduling
//开启aop
@EnableAspectJAutoProxy
//开启事务管理
@EnableTransactionManagement
public class CustomsWebBootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CustomsWebBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomsWebBootApplication.class, args);
	}
}
