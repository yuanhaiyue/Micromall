package com.example.micromall.config;


import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionIdResolver;



@EnableJdbcHttpSession
public class HttpSessionConfig {

    @Bean
    public HeaderHttpSessionIdResolver httpSessionStrategy(){
        return new HeaderHttpSessionIdResolver("Authentication");
    }

//    @Bean
//    public EmbeddedDatabase dataSource(){
//        return new EmbeddedDatabaseBuilder().setType(Emb)
//    }


}
