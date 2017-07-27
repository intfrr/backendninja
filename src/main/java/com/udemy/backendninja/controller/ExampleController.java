package com.udemy.backendninja.controller;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/example")
public class ExampleController {

    public static final String EXAMPLE_VIEW = "example";

    @Autowired
    @Qualifier("exampleComponent")
    private ExampleComponent exampleComponent;

    //Primera forma
    @GetMapping("/exampleString")
    public String exampleString(Model model){
        exampleComponent.sayHello();
        model.addAttribute("people", getPeople());
        return EXAMPLE_VIEW;
    }

    //Segunda Forma de devolver una vista
    @GetMapping("/exampleMAV")
    public ModelAndView exampleMAV(){
        ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
        mav.addObject("people", getPeople());
        return mav;
    }

    private List<Person> getPeople(){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Arnau", 19));
        people.add(new Person("Mikel", 20));
        people.add(new Person("Eva", 21));
        people.add(new Person("Peter", 17));
        return people;
    }

}
