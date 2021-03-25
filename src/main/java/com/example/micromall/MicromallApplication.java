package com.example.micromall;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.micromall.repository")
@SpringBootApplication
public class MicromallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicromallApplication.class, args);
    }

}
