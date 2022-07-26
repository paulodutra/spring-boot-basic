package org.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloWorld {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello world";
    }
//    public static void main( String[] args ) {
//        SpringApplication.run(App.class, args);
//
//    }
}
