package com.cjj.Config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 自定义数据源
 */

@Deprecated //废弃
//@Configuration
public class MyDataSourceConfig {
    //默认的自动配置是判断容器中没有才会自动配置 @ConditionalOnMissingBean({DataSource.class})
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
//        druidDataSource.setDriverClassName();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();
        //加入监控功能stat  开启SQL防火墙防止SQL注入wall
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /**
     * 配置Druid监控页功能
     * 以前配置在web.xml里面的servlet里面
     * deny优先于allow，如果在deny列表中，就算在allow列表中，也会被拒绝。
     * 如果allow没有配置或者为空，则允许所有访问
     */
    @Bean
    public ServletRegistrationBean statviewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registration = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        //监控页添加账号密码登录
       registration.addInitParameter("loginname","admin");
       registration.addInitParameter("loginPassword","123456");
       //允许哪些IP进行访问
      // registration.addInitParameter("allow","192.168.**.**");
        //不允许哪些IP进行访问
       // registration.addInitParameter("deny","192.168.**.**");
        return registration;
    }

    /**
     * webstarfilter 用于web-jdbc数据采集
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        //拦截servlet的路径
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        //放行
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid");
        return  filterRegistrationBean;
    }


}

