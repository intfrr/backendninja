package com.udemy.backendninja.controller;

import com.udemy.backendninja.constant.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    @GetMapping("/contactform")
    private String redirectContactForm(){
        return ViewConstant.CONTACT_FORM;
    }

}
