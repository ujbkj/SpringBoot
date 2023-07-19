package com.cjj.Servlet;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Myfilter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("Myfilter开始运行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("Myfilter销毁");
    }
}
