package com.caijunjie.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
    @GetMapping("/cjj")
    public String gocjj(Model model){
        //model中的数据会被放在请求中request.setArrtibute("a",a)
        model.addAttribute("msg2","Hello world!");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
