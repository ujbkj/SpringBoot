package com.cjj.springboot_web3;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringbootWeb3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWeb3Application.class, args);
    }

}
