package com.marchi.demo.springmvc.controller;

import com.marchi.demo.springmvc.model.DemoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //使用@RestController，声明是控制器，并且返回数据时不需要@ResponseBody
@RequestMapping("/rest")
public class DemoRestController {

    //返回数据的媒体类型为json
    @RequestMapping(value="/getjson",produces={"application/json;charset=UTF-8"})
    public DemoDTO getjson(DemoDTO obj){
        return new DemoDTO(obj.getId(),obj.getName()+"YY");
    }

    //返回数据的媒体类型为xml
    @RequestMapping(value="/getxml")
    public DemoDTO getxml(DemoDTO obj){
        return new DemoDTO(obj.getId(),obj.getName()+"YY");
    }
}
