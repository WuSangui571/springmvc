package com.sangui.springmvc.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-07
 * @Description:
 * @Version: 1.0
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    // 只有返回 true 的时候，程序才能往下走，false 则拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterCeptor#preHandle execute!!!!");
        return true ;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterCeptor#afterCompletion execute!!!!");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterCeptor#postHandle execute!!!!");
    }
}
