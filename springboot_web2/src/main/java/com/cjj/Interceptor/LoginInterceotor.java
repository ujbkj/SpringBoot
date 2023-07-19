package com.cjj.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截
 * 1.配置好拦截器要拦截哪些请求
 * 2.把这些配置放在容器中
 */
@Slf4j
public class LoginInterceotor implements HandlerInterceptor {
    /**
     * 目标执行之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI();
        log.info("preHandle拦截的请求路径是{}",url);

        //登录检查逻辑
        HttpSession session=request.getSession();
        Object bookUser=session.getAttribute("bookUser");
        if (bookUser!=null){
            //放行
            return true;
        }
        //拦截器 ,未登录，跳转到登录页
//      session.setAttribute("msg","请先登录！");
//        response.sendRedirect("/");
        request.setAttribute("msg","请先登录！");
        request.getRequestDispatcher("/").forward(request,response);

        return false;
    }

    /**
     * 目标方法执行完成后
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }

    /**
     * 页面渲染之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}",ex);
    }
}
