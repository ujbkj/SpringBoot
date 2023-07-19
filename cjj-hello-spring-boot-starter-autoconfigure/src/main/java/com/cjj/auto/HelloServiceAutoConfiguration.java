package com.cjj.auto;


import com.cjj.bean.HelloProperties;
import com.cjj.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)//默认放在容器中
public class HelloServiceAutoConfiguration {
    @ConditionalOnMissingBean(HelloService.class)
    @Bean
    public HelloService helloService(){
        HelloService helloService=new HelloService();
        return helloService;
    }
}
