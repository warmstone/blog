package com.ballcat.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author pengshun
 * @date 2022-04-06 21:29
 * @description
 */
@SpringBootApplication
@MapperScan(basePackages = "com.ballcat.blog.mapper")
public class BlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }
}
