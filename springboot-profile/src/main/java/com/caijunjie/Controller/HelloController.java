package com.caijunjie.Controller;


import com.caijunjie.Bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${person.name:张三}")
    private String name;

    @Autowired
    private Person person;
    @GetMapping("/")
    public String hello(){
      return person.getClass().toString();
    }

    @GetMapping("/person")
    public Person person(){
        return person;
    }
}
