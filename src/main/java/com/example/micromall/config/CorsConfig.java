package com.example.micromall.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author 14760
 */
@Configuration
public class CorsConfig {
    public CorsConfig(){}

    @Bean
    public CorsFilter corsFilter(){
        //添加cors 配置信息
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://127.0.0.1:5500");

        corsConfiguration.addAllowedOrigin("http://10.20.54.210:5500");
        //是否发现cookie
        corsConfiguration.setAllowCredentials(true);
        //设置允许的请求
        corsConfiguration.addAllowedMethod("*");
        //设置允许的头
        corsConfiguration.addAllowedHeader("*");
        //为url 添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource=new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsFilter(corsConfigurationSource);
    }
}
