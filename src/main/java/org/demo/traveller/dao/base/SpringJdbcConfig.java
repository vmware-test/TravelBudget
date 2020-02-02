package org.demo.traveller.dao.base;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan("org.demo.traveller")
public class SpringJdbcConfig {
	@Bean
	public DataSource dataSource() {
	    return new EmbeddedDatabaseBuilder()
	        .setType(EmbeddedDatabaseType.HSQL)
	        .addScript("classpath:sql/traveller_ddl.sql")
	        .addScript("classpath:sql/traveller_dml.sql").build();
	}
}