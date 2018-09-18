package com.customs.configuration;

import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/** 
 * SqlSessionFactory配置 
 */
//@Configuration
public class SqlSessionFactoryConfiguration {

	@Qualifier("dataSourceMaster")
	@Autowired
	private DataSource dataSouce;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean(Environment env) throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		String mybatisConfigFile = env.getProperty("mybatis.config.file");
		String mappingPath = env.getProperty("mybatis.mapping");
		String entityPackage = env.getProperty("mybatis.entity.package");
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFile));
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mappingPath;
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
		sqlSessionFactoryBean.setDataSource(dataSouce);
		sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
		return sqlSessionFactoryBean;
	}
}
