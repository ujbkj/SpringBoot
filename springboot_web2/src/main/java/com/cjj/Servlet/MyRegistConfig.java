package com.cjj.Servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

/**
 * 两个servlet
 * 1.Myservlet  --> /my
 * 2.dispatcherservlet  -->  /
 */
//proxyBeanMethods = false 当前类每一次调用类的方法，每次都会新建一次，保证依赖用的组件始终都是单实例的
@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        Myservlet myservlet = new Myservlet();
        return new ServletRegistrationBean(myservlet,"/my","/my02");
        
    }
    
    @Bean
    public FilterRegistrationBean myfilter(){

        Myfilter myfilter = new Myfilter();
        //第一种写法，拦截myServlet
        //return new FilterRegistrationBean(myfilter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myfilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return  filterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener listener=new MyServletContextListener();
        return new ServletListenerRegistrationBean(listener);
    }
}
