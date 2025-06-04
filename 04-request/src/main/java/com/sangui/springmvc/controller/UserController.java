package com.sangui.springmvc.controller;


import com.sangui.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-03
 * @Description:
 * @Version: 1.0
 */
@Controller
public class UserController {
    /**
     * 注册
     * @return 转到注册页面 register
     */
    @RequestMapping("/")
    public String registerMethod(){
        return "register";
    }

//    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
//    public String register(HttpServletRequest request){
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String sex = request.getParameter("sex");
//        String[] interest = request.getParameterValues("interest");
//        String intro = request.getParameter("intro");
//        System.out.println("username=" + username + ",password=" + password + ",sex=" + sex + ",interest=" + Arrays.toString(interest) + ",intro=" + intro);
//        return "register-success";
//    }

//    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
//    public String register(@RequestParam("username") String username,
//                           @RequestParam("username") String password,
//                           @RequestParam("sex") Integer sex,
//                           @RequestParam("interest") String[] interest,
//                           @RequestParam("intro") String intro){
//
//
//        System.out.println("username=" + username + ",password=" + password + ",sex=" + sex + ",interest=" + Arrays.toString(interest) + ",intro=" + intro);
//        return "register-success";
//    }


//@RequestMapping(value = "/user/register",method = RequestMethod.POST)
//public String register(String username,
//                       String password,
//                       Integer sex,
//                       String[] interest,
//                       String intro){
//    System.out.println("username=" + username + ",password=" + password + ",sex=" + sex + ",interest=" + Arrays.toString(interest) + ",intro=" + intro);
//    return "register-success";
//}

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public String register(User user,
                           @CookieValue(value="id", required = false, defaultValue = "2222222222") String id){
        System.out.println(user);
        System.out.println("user 的名字为：" + user.getUsername());
        System.out.println(user.getUsername().equals("张三"));
        System.out.println(id);
        return "register-success";
    }

}
