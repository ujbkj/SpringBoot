package com.catering.file;

import com.catering.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 * 文件服务
 *
 * @author sy
 */
@EnableCustomSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CateRingFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(CateRingFileApplication.class, args);
    }

}
