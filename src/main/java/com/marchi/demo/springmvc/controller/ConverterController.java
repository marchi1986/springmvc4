package com.marchi.demo.springmvc.controller;

import com.marchi.demo.springmvc.model.DemoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ConverterController {

    @RequestMapping(value="/convert",produces={"application/x-marchi"})
    public @ResponseBody DemoDTO convert(@RequestBody DemoDTO demoDTO){
        return demoDTO;
    }
}
