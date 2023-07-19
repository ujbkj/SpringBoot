package com.caijunjie.springboot_web;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.logging.Logger;

@SpringBootApplication
@ServletComponentScan
public class SpringBootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

}
