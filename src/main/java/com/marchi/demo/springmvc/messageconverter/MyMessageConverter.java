package com.marchi.demo.springmvc.messageconverter;

import com.marchi.demo.springmvc.model.DemoDTO;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoDTO>{

    //自定义媒体类型 application/x-marchi
    public MyMessageConverter(){
        super(new MediaType("application","x-marchi", Charset.forName("UTF-8")));
    }

    //表明我们处理由“-”隔开的数据，并转成DemoDTO对象
    @Override
    protected DemoDTO readInternal(Class<? extends DemoDTO> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp= StreamUtils.copyToString(httpInputMessage.getBody(),Charset.forName("UTF-8"));
        String[] tempArr=temp.split("-");
        return new DemoDTO(new Long(tempArr[0]),tempArr[1]);
    }

    //只处理DemoDTO这个类
    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoDTO.class.isAssignableFrom(aClass);
    }

    //如何输出到response
    @Override
    protected void writeInternal(DemoDTO demoDTO, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out="hello:"+demoDTO.getId()+"-"+demoDTO.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
