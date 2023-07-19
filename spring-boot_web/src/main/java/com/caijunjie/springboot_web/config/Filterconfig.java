package com.caijunjie.springboot_web.config;
import lombok.extern.log4j.Log4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Log4j
@WebFilter(urlPatterns = "/save",filterName = "filters")
public class Filterconfig implements Filter {
    static Logger logger = LogManager.getLogger(Filterconfig.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("--------执行过滤器---------");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        String uri=httpServletRequest.getRequestURI();
        String method=httpServletRequest.getMethod();
        String parameter=httpServletRequest.getParameter("usename");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request,response);
        logger.info("---------执行过滤器成功-----");
        logger.info("请求路径："+uri+"请求方式："+method);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        logger.info("--------销毁过滤器---------");
    }
}
