package com.habuma.ttt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.habuma.ttt.DweetController;
import com.habuma.ttt.DweetRepository;
import com.habuma.ttt.JdbcDweetRepository;

/**
 * Automatic beans via component-scan and autowire
 */
@Configuration
public class AppConfig {
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	
	@Autowired
	DataConfig dataConfig;

//	@Bean
//	public DweetController dweetController() {
//		logger.info("dweetController configured..");
//		return new DweetController(dweetRepository());
//	}

	// Not needed when class is @Repository-annotated and @Autowired for constructor injection
//	@Bean
//	public DweetRepository dweetRepository() {
//		logger.info("dweetRepository configured..");
//		return new JdbcDweetRepository(jdbcOperation());
//	}

	@Bean
	public JdbcOperations jdbcOperation() {
		logger.info("Configuring JdbcOperation...");

		return new JdbcTemplate(dataConfig.dataSource());
	}

}
