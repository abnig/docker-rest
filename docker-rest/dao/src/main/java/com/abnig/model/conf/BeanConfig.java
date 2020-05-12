package com.abnig.model.conf;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.abnig.model" })
@ComponentScan("com.abnig")
@PropertySource(value = {"application.properties"})
public class BeanConfig {
	
	@SuppressWarnings("unused")
	@Autowired
	private Environment environment;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan("com.abnig.model");
		entityManagerFactoryBean.setPersistenceUnitName("entityManager");
		return entityManagerFactoryBean;
	}

	
	@Bean
	public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
		return transactionManager;
	}

	@Bean
	public HikariDataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("org.postgresql.Driver");
		hikariConfig.setJdbcUrl("jdbc:postgresql://172.17.0.2:5432/abnig19");
		hikariConfig.setUsername("abnig");
		hikariConfig.setPassword("abnig");
		hikariConfig.setMaximumPoolSize(10);
		hikariConfig.setSchema("public");		
		hikariConfig.setConnectionTestQuery("SELECT 1");
//		Properties dsProperties = new Properties();
//		dsProperties.setProperty("serverTimezone",environment.getProperty("serverTimezone"));
//		dsProperties.setProperty("useSSL", environment.getProperty("useSSL"));
//		dsProperties.setProperty("verifyServerCertificate", environment.getProperty("verifyServerCertificate"));
//		hikariConfig.setDataSourceProperties(dsProperties);
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}

}
