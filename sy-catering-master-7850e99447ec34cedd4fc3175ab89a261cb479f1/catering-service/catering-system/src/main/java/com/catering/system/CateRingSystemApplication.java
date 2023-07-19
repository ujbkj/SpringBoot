package com.catering.system;

import com.catering.common.security.annotation.EnableCustomConfig;
import com.catering.common.security.annotation.EnableCRFeignClients;
import com.catering.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 系统模块
 *
 * @author catering
 */

@EnableCustomConfig
@EnableCustomSwagger2
@EnableCRFeignClients
@SpringCloudApplication
public class CateRingSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CateRingSystemApplication.class, args);
    }
}
