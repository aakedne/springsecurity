package com.example.springsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    //Method for view controllers
    // helps navigate route
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/home").setViewName("home"); // set view name home (Homepage)
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        //Login



    }

}
