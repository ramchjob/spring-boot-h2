package com.sq.learn.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfig {

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testdb");
		dataSourceBuilder.username("sa");
		dataSourceBuilder.password("");
		DataSource source = dataSourceBuilder.build();
		return new JdbcTemplate(source);
	}

}
