//package com.cjj.exception;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 自定义异常解析器
// * 所有状态码为5开头的异常执行resolveException
// */
//@Order(value = Ordered.HIGHEST_PRECEDENCE) //优先级  数据越小 优先级越高
//@Component
//public class CustomerHanderExceptionResolver implements HandlerExceptionResolver {
//    @Override
//    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//        try {
//            response.sendError(511,"511错误");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return new ModelAndView();
//    }
//}
