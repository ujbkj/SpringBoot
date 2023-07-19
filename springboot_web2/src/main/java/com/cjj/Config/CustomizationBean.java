package com.cjj.Config;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;

/*
 * 自定义servlet的容器
 * 自定义定制化器，改变WebServerFactoryCustomizer的默认规则
 * 把配置文件的值和ServletWebServerFactory 进行绑定
 * 默认先加载自定义加载（自定义容器优先于ConfigurableServletWebServerFactory工厂）
 */
@Configuration
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    @Override
    public void customize(ConfigurableWebServerFactory factory) {
            factory.setPort(8080);
    }
}
