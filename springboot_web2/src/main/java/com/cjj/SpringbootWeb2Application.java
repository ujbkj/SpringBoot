package com.cjj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.cjj")
@MapperScan("com.cjj.Mapper")
public class SpringbootWeb2Application  {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb2Application.class, args);
    }

}
