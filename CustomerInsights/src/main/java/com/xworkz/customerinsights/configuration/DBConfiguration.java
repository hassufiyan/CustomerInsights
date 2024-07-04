package com.xworkz.customerinsights.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;


@Configuration
public class DBConfiguration {
	
	
//private Loggers logger=getLogger();
	
	public DBConfiguration() {
		System.out.println("Connected to data base in DB Configuration");
//		Loggers.getLogger().info("Connected to data base in DB Configuration");
//	logger.
}
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManager() {
		System.out.println("creating emfbean to get entityManagerFactory");
		LocalEntityManagerFactoryBean emfBean=new LocalEntityManagerFactoryBean();
		emfBean.setPersistenceUnitName("customer-insights");
		return emfBean;
		
	}

	
}
