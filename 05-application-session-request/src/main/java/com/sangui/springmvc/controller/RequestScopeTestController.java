package com.sangui.springmvc.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-04
 * @Description:
 * @Version: 1.0
 */
@Controller
public class RequestScopeTestController {
    @RequestMapping("/testServletApi")
    public String testServletApi(HttpServletRequest request){
        request.setAttribute("testRequestScope","在SpringMVC当中使用原生Servlet API完成 request 域数据共享");
        return "ok";
    }

    @RequestMapping("/testModel")
    public String testModelMethod(Model model){
        model.addAttribute("testRequestScope","在SpringMVC当中使用 model 完成 request 域数据共享");
        return "ok";
    }

    @RequestMapping("/testMap")
    public String testMapMethod(Map<String,Object> map){
        map.put("testRequestScope","在SpringMVC当中使用 map 完成 request 域数据共享");
        return "ok";
    }

    @RequestMapping("/testModelMap")
    public String testModelMapMethod(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","在SpringMVC当中使用 modelMap 完成 request 域数据共享");
        return "ok";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndViewMethod(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("testRequestScope","在SpringMVC当中使用 modelAndView 完成 request 域数据共享");
        modelAndView.setViewName("ok");
        return modelAndView;
    }
}
