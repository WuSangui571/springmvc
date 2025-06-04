package com.sangui.springmvc.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-04
 * @Description:
 * @Version: 1.0
 */
@Controller
@SessionAttributes("testSessionScope")
public class SessionScopeTestController {
    @RequestMapping("/testSessionServletApi")
    public String testServletApiMethod(HttpSession session){
        session.setAttribute("testSessionScope","在SpringMVC当中使用原生Servlet API完成 session 域数据共享");
        return "ok";
    }

    @RequestMapping("/testSessionAttributes")

    public String testSessionAttributes(ModelMap modelMap){

        modelMap.addAttribute("testSessionScope","在SpringMVC当中使用原生 SessionAttributes 注解完成 session 域数据共享");
        return "ok";
    }
}
