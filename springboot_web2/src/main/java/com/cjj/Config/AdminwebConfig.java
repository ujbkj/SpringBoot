package com.cjj.Config;
import com.cjj.Interceptor.LoginInterceotor;
import com.cjj.Interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中（实现WebMvcConfigurer的addPathPatterns）
 * 3.指定拦截器规则【如果是拦截使用，静态资源也会被拦截】
 * @EnableWebMvca:全面接管
 *      1.静态资源  视图解析器  欢迎页 ...等都会失效
 *
 *
 */
//@EnableWebMvc
@Configuration
public class AdminwebConfig implements WebMvcConfigurer {
    /**
     * filter 、Interceptor 几乎拥有相同的功能
     * 1.filter 是servlet定义的原生组件。好处。脱离spring应用也能使用
     * 2.Interceptor是spring定义的接口，可以spring的自动装配等功能
     */
    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceotor())
                .addPathPatterns("/**")// 使用请求都被拦截，静态资源也会被拦截
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sta/**","/savauser","/book","/favicon.ico"); //放行的请求

        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/sta/**","/savauser","/book","/favicon.ico");
    }

    /**
     * 定义静态资源行为
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        /**
//         * 访问/sta/**所有请求都去/static/**下面进行匹配
//         */
//        registry.addResourceHandler("/sta/**")
//                .addResourceLocations("classpath:/static/");
//    }

    //    @Bean
//    public WebMvcRegistrations webMvcRegistrations(){
//        return new WebMvcRegistrations() {
//            @Override
//            public RequestMappingHandlerMapping getRequestMappingHandlerMapping(){
//                return null;
//            }
//
//        };
//
//    }
}
