package com.sangui.springmvc.controller;


import com.sangui.springmvc.pojo.User;
import com.sangui.springmvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-06
 * @Description:
 * @Version: 1.0
 */
@Controller
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView userList(){
        List<User> users = userService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",users);
        System.out.println(users);
        modelAndView.setViewName("user_list");
        return modelAndView;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String addUser(User user){
        userService.saveUser(user);
        System.out.println(user);
        System.out.println("POSTPOSTPOSTPOSTPOSTPOSTPOSTPOSTPOSTPOSTPOSTPOSTPOSTPOST");
        return "redirect:/user";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ModelAndView userDetail(@PathVariable("id") Long id){
        User user = userService.selectOne(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("user_edit");
        return modelAndView;
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(User user){
        userService.updateUser(user);
        System.out.println("PUTPUTPUTPUTPUTPUTPUTPUTPUTPUTPUTPUTPUTPUT");
        System.out.println(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
