package com.supconit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(value = "com.supconit.dao.mapper")
public class MicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroApplication.class, args);
    }

}
