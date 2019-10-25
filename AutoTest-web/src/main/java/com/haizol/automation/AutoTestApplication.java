package com.haizol.automation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname AutoTestApplication
 * @Date 2019/9/21 19:25
 * @Created by StevenZsh
 * @Description TODO
 */
@SpringBootApplication
@MapperScan("com.haizol.automation.mapper")
public class AutoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoTestApplication.class, args);
    }
}
