package com.catering.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 网关启动程序
 *
 * @author catering
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CateRingGatewayApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(com.catering.gateway.CateRingGatewayApplication.class, args);
    }
}
