package com.example.micromall.config;

import com.example.micromall.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * @author 14760
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

//    final LoginInterceptor loginInterceptor;
//
//    public WebConfigurer(LoginInterceptor loginInterceptor) {
//        this.loginInterceptor = loginInterceptor;
//    }
//

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login","/user/register","/category/list",
                        "/product/list","/product/details","/product/cart","/image/list","/news/list",
                        "/news/detail"
                );



    }
}
