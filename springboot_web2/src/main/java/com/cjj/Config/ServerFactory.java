package com.cjj.Config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过ConfigurableServletWebServerFactory更改默认规则
 * 自定义默认规则
 * 默认先加载WebserverFactory加载
 */
@Deprecated
//@Configuration
public class ServerFactory {
    /**
     * 更改tomcat的默认规则（例如端口号，地址等）
     * @return
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(){
        TomcatServletWebServerFactory factory=new TomcatServletWebServerFactory();
        factory.setPort(99);
        return factory;
    }
}
