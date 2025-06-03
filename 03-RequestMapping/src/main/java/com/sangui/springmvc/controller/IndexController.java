package com.sangui.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-03
 * @Description:
 * @Version: 1.0
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String indexMethod(){
        return "index";
    }

    @RequestMapping({"/testVal1","/testVal2","/testVal3"})
    public String testValue(){
        return "test_value";
    }

    //@RequestMapping("/?hz")
    //@RequestMapping("/*hz")
    @RequestMapping("/hz/**")
    public String OkMethod(){
        return "ok";
    }

    @RequestMapping("/login/{username}/{password}")
    public String testRESTFulURL(@PathVariable("username") String username,
                                 @PathVariable("password") String password){
        System.out.println("username=" + username + ",password=" + password);
        return "ok";
    }

    //@RequestMapping(value = {"/user/login"},method = RequestMethod.POST)
    @PostMapping(value = {"/user/login"})
    public String userLogion(){
        System.out.println("POST-------login process execute...");
        return "ok";
    }

    @RequestMapping(value = {"/user/login"},method = RequestMethod.GET)
    public String userLogion2(){
        System.out.println("GET-------login process execute...");
        return "ok";
    }

    //@RequestMapping(value = "/product/login",params = {"username","password"})
    //@RequestMapping(value = "/product/login",params = {"!username","password"})
    @RequestMapping(value = "/product/login",params = {"username!=admin","password"})
    public String testParams(){
        return "ok";
    }

    // 只有请求头中有 accept 和 accept-encoding 才可以进行浏览
    @RequestMapping(value = "/testHeader",headers = {"accept","accept-encoding"})
    public String testHeader(){
        return "ok";
    }
}
