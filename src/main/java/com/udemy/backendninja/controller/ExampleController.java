package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    //Primera forma
    @GetMapping("/exampleString")
    public String exampleString(Model model){
        model.addAttribute("person", new Person("Arnau", 20));
        return EXAMPLE_VIEW;
    }

    //Segunda Forma de devolver una vista
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("person", new Person("Arnau García", 19));
        return mav;
    }

}
