package com.catering.auth;

import com.catering.common.security.annotation.EnableCRFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 认证授权中心
 *
 * @author catering
 */
@EnableCRFeignClients
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CateRingAuthApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(com.catering.auth.CateRingAuthApplication.class, args);
    }
}
