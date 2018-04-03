package com.marchi.demo.springmvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marchi.demo.springmvc.model.DemoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller //注解声明此类是一个控制器
@RequestMapping("/anno") //映射此类的访问路径是/anno
public class DemoAnnoController {

    //此方法未标注路径，因此使用类级别的路径/anno;produces可定制返回的response的媒体类型和字符集
    //接受HttpServletRequest、HttpServletResponse作为参数
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request, HttpServletResponse response){
        return "url:"+request.getRequestURI()+" can access";
    }

    //接受路径参数，并在方法参数前结合@PathVariable 使用，访问路径为 /anno/pathvar/xx
    @RequestMapping(value="/pathvar/{str}", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can access,str:"+str;
    }

    //演示常规的request参数获取，访问路径为/anno/requestParam?id=1
    @RequestMapping(value="/requestParam", produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can access,id:"+id;
    }

    //解析参数到对象，访问路径/anno/obj?id=1&name=xx
    @RequestMapping(value="/obj", produces = "application/json;charset=UTF-8")
    public @ResponseBody String passObj(DemoDTO demoDTO, HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can access,demoDTO:"+demoDTO;
    }

    //映射不同的路径到相同的方法，访问路径为/anno/name1 或 /anno/name2
    @RequestMapping(value={"/name1","/name2"}, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String remove(HttpServletRequest request){
        ObjectMapper om=new ObjectMapper();
        return "url:"+request.getRequestURI()+" can access";
    }


}
