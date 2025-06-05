package com.sangui.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-05
 * @Description:
 * @Version: 1.0
 */
@Controller
public class ForwardController {
    @RequestMapping("/a")
    public String forwardToA(){
        return "redirect:/b";
    }

    @RequestMapping("/b")
    public String forwardToB(){
        return "b";
    }
}
