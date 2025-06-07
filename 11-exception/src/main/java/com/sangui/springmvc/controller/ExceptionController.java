package com.sangui.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: sangui
 * @CreateTime: 2025-06-07
 * @Description:
 * @Version: 1.0
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler
    public String exceptionHandler(Exception e, Model model){
        model.addAttribute("errMsg",e);
        return "error";
    }
}
