package com.sangui.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-07
 * @Description:
 * @Version: 1.0
 */
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String toIndexMethod(){
        System.out.println("IndexController#toIndexMethod execute!!!!!!!!!!!!!!!!!!");
        return "index";
    }
}
