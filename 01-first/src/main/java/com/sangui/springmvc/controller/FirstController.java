package com.sangui.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-02
 * @Description:
 * @Version: 1.0
 */
@Controller
public class FirstController {

    @RequestMapping("/first")
    public String firstMethod(){
        return "first";
    }

    @RequestMapping("/second")
    public String secondMethod(){
        return "second";
    }

    @RequestMapping("/")
    public String indexMethod(){
        return "index";
    }
}
