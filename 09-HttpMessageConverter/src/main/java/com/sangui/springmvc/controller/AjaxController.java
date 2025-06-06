package com.sangui.springmvc.controller;


import com.sangui.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-06
 * @Description:
 * @Version: 1.0
 */
//@Controller
@RestController
public class AjaxController {
    //    @RequestMapping(value = "/ajax",method = RequestMethod.GET)
    //    public String ajax(HttpServletResponse response) throws IOException {
    //        PrintWriter out = response.getWriter();
    //        out.println("hello ajax,my name is Spring MVC");
    //        return null;
    //    }

//    @RequestMapping(value = "/ajax",method = RequestMethod.GET)
//    @ResponseBody
//    public String ajax(){
//        return "hello ajax,my name is Spring MVC";
//    }

    @RequestMapping(value = "/ajax",method = RequestMethod.GET)
    public User ajax(){
        User user = new User(10L,"zhangsan","333");
        return user;
    }
}
