package com.example.micromall.config;


import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


/**
 * @author 14760
 */
@EnableJdbcHttpSession
public class HttpSessionConfig {

    @Bean
    public HeaderHttpSessionIdResolver httpSessionStrategy(){
        return new HeaderHttpSessionIdResolver("Authorization");
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }


}
