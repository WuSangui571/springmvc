package com.sangui.springmvc.controller;


import com.sangui.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-05
 * @Description:
 * @Version: 1.0
 */
@Controller
public class UserController {
    // 查询操作，在postman里选择none即可
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","user查询所有结果中......");
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    // 查询操作，在postman里选择none即可
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ModelAndView getOne(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","id= " + id + "的user查询中......");
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    // 增加操作。在postman里选择 POST 以及 x-www-form-urlencoded
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ModelAndView addOne(User user){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("user:" + user+ "add......");
        modelAndView.addObject("msg","user:" + user+ "add......");
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    // 删除操作在postman里选择none即可
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteOne(@PathVariable("id") String id,User user){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("user:" + id + "is delete......");
        modelAndView.addObject("msg","user:" + id+ "is delete......");
        modelAndView.setViewName("ok");
        return modelAndView;
    }

    // 修改操作。在postman里选择Body->raw->JSON，写json格式： {"username": "111","password": "222"}
    // 注意添加jackson-databind依赖，和在方法输入参数里写上@RequestBody注解
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public ModelAndView updateOne(@RequestBody User user){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("new user:" + user + "is update......");
        modelAndView.addObject("msg","new user:" + user + "is update......");
        modelAndView.setViewName("ok");
        return modelAndView;
    }
}
