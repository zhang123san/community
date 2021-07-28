package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动服务器
 * @Author weixianbo
 * @CreateTime 2021/7/22 9:35
 * @Version 1.0.0
 */
@SpringBootApplication
@MapperScan("com.demo.database.mapper")
public class StartUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartUpApplication.class, args);
    }

}
