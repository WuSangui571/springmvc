package com.sangui.springmvc.controller;


import com.sangui.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-06
 * @Description:
 * @Version: 1.0
 */
@Controller
public class RequestBodyController {

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody User user){
        System.out.println(user);
        return "后端收到信息！";
    }
}
