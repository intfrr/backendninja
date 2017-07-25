package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    //Primera forma
    @GetMapping("/exampleString")
    public String exampleString(){
        return EXAMPLE_VIEW;
    }

    //Segunda Forma de devolver una vista
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        return new ModelAndView(EXAMPLE_VIEW);
    }

}
