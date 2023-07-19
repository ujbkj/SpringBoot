package com.cjj.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {
    @Autowired
    StringRedisTemplate redisTemplate;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         String url = request.getRequestURI();
         //默认名称访问当前URL就会加1
        //自增增
         redisTemplate.opsForValue().increment(url);
         return true;
    }
}
