package com.sangui.springmvc.controller;


import jakarta.servlet.ServletConnection;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-04
 * @Description:
 * @Version: 1.0
 */
@Controller
public class ApplicationController {
    @RequestMapping("/testApplication")
    public String testApplicationMethod(HttpServletRequest request){
        ServletContext application = request.getServletContext();
        application.setAttribute("testApplicationScope","在SpringMVC当中使用原生 Servlet API 完成 application 域数据共享");
        return "ok";
    }
}
