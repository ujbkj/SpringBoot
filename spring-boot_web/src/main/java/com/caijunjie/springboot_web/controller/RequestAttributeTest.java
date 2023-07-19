package com.caijunjie.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestAttributeTest {
    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","成功请求success2");
        request.setAttribute("code",200);
        return "forward:success2"; //转发到 /success2请求
    }

    @GetMapping("/params")
    public String testparm(Map<String,Object> map,
                           Model model,
                           HttpServletRequest request,
                           HttpServletResponse response){
        map.put("hello","world666");
        model.addAttribute("world","hello666");
        request.setAttribute("message","helloworld");
        Cookie cookie = new Cookie("c1","cooke1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);
        return "forward:/success2";
    }

    @ResponseBody
    @GetMapping("/success2")
    public Map success(@RequestAttribute(value = "msg",required = false) String msg,
                       @RequestAttribute(value = "code",required = false) Integer code,
                       HttpServletRequest request){
     Object msg1=request.getAttribute("msg");

     Object hello= request.getAttribute("hello");
     Object world= request.getAttribute("world");
     Object message= request.getAttribute("message");

     Map<String,Object> map=new HashMap<>();
     map.put("reqMethod_msg",msg1);
     map.put("annotation_msg",msg);

     map.put("hello",hello);
     map.put("world",world);
     map.put("message",message);
        return map;
    }
}
