package com.marchi.demo.springmvc.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice//声明控制器建言
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value=Exception.class)//定义全局处理，通过value可以过滤拦截条件，此处拦截所有Exception
    public ModelAndView exception(Exception e, WebRequest request){
        ModelAndView modelAndView =new ModelAndView("error");
        modelAndView.addObject("errorMessage",e.getMessage());
        return modelAndView;
    }

    @ModelAttribute//将键值对添加到全局，所有注解@RequestMapping的方法可获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder//注解定制WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");

    }
}
