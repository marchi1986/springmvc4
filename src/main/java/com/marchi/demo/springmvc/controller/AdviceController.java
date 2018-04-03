package com.marchi.demo.springmvc.controller;

import com.marchi.demo.springmvc.model.DemoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoDTO demoDTO){
        System.out.println(demoDTO.getId());
        System.out.println(demoDTO.getName());
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+msg);
    }
}
