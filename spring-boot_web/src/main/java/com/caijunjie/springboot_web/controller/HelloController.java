package com.caijunjie.springboot_web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/01.jpeg")
    public String hello() {
        return "宇智波鼬";
    }
//    获取用户
//  @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping(value = "/user")
    public String getUser(){
        return "GET-张三";
    }
//    保存用户
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String postUser(){
        return "POST-张三";
    }
//    修改用户
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }
//    删除用户
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }
}
