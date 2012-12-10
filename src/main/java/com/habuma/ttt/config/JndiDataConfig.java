package  com.habuma.ttt.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class JndiDataConfig implements DataConfig {
	private static final Logger logger = LoggerFactory.getLogger(JndiDataConfig.class);
	
	@Override
	@Bean
	public DataSource dataSource(){
		Context ctx;
		try {
			ctx = new InitialContext();
			logger.info("Looking up jndi DataSource...");
			return (DataSource) ctx.lookup("java:comp/env/jdbc/ds");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
