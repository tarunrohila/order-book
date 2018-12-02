package com.creditsuisse.orderbook.app.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class is created to keep all configuration related to db connectivity
 * 
 * @author Tarun Rohila
 * @since Nov 29, 2018
 */
@EnableJpaRepositories(basePackages = "com.creditsuisse.orderbook.app.repository", entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
@EnableTransactionManagement
@Configuration
public class DBConfig {
	
	/**
	 * Autowired environment dependency.
	 */
	@Autowired
	private Environment environment;

	/**
	 * Create DataSource to connect with specific database
	 * 
	 * @return - dataSource
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("spring.jpa.properties.jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("spring.jpa.properties.jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("spring.jpa.properties.jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("spring.jpa.properties.jdbc.password"));
		return dataSource;
	}

	/**
	 * Entitiy Manager factory.
	 * 
	 * @return - factoryBean
	 * @throws NamingException
	 *             -NamingException
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(new String[] { "com.creditsuisse.orderbook.app.repository" });
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.setJpaProperties(jpaProperties());
		return factoryBean;
	}

	/**
	 * JPA vendor adaptor to connect with JPA
	 * 
	 * @return - hibernateJpaVendorAdapter
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		return hibernateJpaVendorAdapter;
	}

	/**
	 * JPA properties
	 * 
	 * @return - properties
	 */
	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("spring.jpa.properties.hibernate.hbm2ddl.auto"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("spring.jpa.properties.hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("spring.jpa.properties.hibernate.format_sql"));
		return properties;
	}

	/**
	 * Transaction Manager
	 * 
	 * @param emf
	 *            - entityManagerFactory
	 * @return txManager - transaction manager
	 */
	@Bean
	@Autowired
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}


}
