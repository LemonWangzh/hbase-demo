package com.kars.hbaseclient;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.kars")
@MapperScan(basePackages = "com.kars.dao.mapper")
public class HbaseClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(HbaseClientApplication.class, args);
    }

}
