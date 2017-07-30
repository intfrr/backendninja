package com.udemy.backendninja.controller;

import com.udemy.backendninja.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ejercicio")
public class TestController {

    public static final String EXAMPLE_VIEW = "example";

    @Autowired
    @Qualifier("testService")
    private TestService testService;

    @GetMapping("/ejercicio1")
    public String getEjercicio1(){
        return "redirect:/ejercicio/ejercicio2";
    }

    @GetMapping("ejercicio2")
    public ModelAndView getEjercicio2(){
        ModelAndView modelAndView = new ModelAndView(EXAMPLE_VIEW);
        testService.getLog();
        modelAndView.addObject("message","message");
        return modelAndView;
    }

}
