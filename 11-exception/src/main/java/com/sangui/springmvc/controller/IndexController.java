package com.sangui.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-07
 * @Description:
 * @Version: 1.0
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String indexMethod(){
        return "index";
    }
}
