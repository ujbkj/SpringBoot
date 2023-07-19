package com.example.listener;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

public class MySpringApplicationRunListener implements SpringApplicationRunListener {
    private  SpringApplication application;
    public MySpringApplicationRunListener(SpringApplication application,String[] args){
        this.application=application;
    }

    @Override
    //开始运行
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.out.println("MySpringApplicationRunListener.......starting");

    }

    @Override
    //环境准备配置
    public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
        System.out.println("MySpringApplicationRunListener.......environmentPrepared");
    }

    @Override
    //IOC容器准备完成
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener.......contextPrepared");
    }

    @Override
    //IOC加载完成
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener.......contextLoaded");
    }

    @Override

    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("MySpringApplicationRunListener.......started");
    }

    @Override
    //IOC启动
    public void started(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener.......started");
    }

    @Override
    public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
        System.out.println("MySpringApplicationRunListener.......ready");
    }

    @Override
    //IOC实例创建完成，启动
    public void running(ConfigurableApplicationContext context) {
        System.out.println("MySpringApplicationRunListener.......running");
    }

    @Override
    //失败异常
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("MySpringApplicationRunListener.......failed");
    }
}
