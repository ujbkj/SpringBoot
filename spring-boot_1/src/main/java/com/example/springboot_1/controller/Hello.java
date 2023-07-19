package com.example.springboot_1.controller;

import com.example.springboot_1.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Autowired Person person;
    @RequestMapping("/hello")
    public Person hello(){
        System.out.println(person+"\n");
        return person;
    }

}
