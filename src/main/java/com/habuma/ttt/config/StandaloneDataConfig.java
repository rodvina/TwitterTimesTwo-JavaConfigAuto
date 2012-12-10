package  com.habuma.ttt.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@Profile("local")
public class StandaloneDataConfig implements DataConfig {
	private static final Logger logger = LoggerFactory.getLogger(StandaloneDataConfig.class);
	
	@Override
	@Bean
	public DataSource dataSource() {
		logger.info("Configuring StandAlone DataSource...");
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("classpath:schema.sql")
				.build();
	}

}
