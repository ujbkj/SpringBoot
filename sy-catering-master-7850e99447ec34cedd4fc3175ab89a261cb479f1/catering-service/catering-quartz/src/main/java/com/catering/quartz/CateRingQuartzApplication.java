package com.catering.quartz;

import com.catering.common.security.annotation.EnableCRFeignClients;
import com.catering.common.security.annotation.EnableCustomConfig;
import com.catering.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@EnableCustomConfig
@EnableCustomSwagger2
@EnableCRFeignClients
@SpringCloudApplication
public class CateRingQuartzApplication {
    public static void main(String[] args) {
        SpringApplication.run(CateRingQuartzApplication.class, args);
    }
}
