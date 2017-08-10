package com.udemy.backendninja.controller;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacts")
public class ContactController {

    private static final Log LOG = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("contactServiceImpl")
    ContactService contactService;

    @GetMapping("/contactform")
    public String redirectContactForm(Model model){
        model.addAttribute("contactModel", new ContactModel());
        return ViewConstant.CONTACT_FORM;
    }

    @GetMapping("/cancel")
    public String cancel(){
        return ViewConstant.CONTACTS;
    }

    @PostMapping("/addcontact")
    public String addContact(@ModelAttribute(name = "contactModel") ContactModel contactModel,
                             Model model){
        model.addAttribute("result", 1);
        LOG.info("Method: addContact() - Params: contactModel=" + contactModel.toString());

        if (contactService.addContact(contactModel) != null){
            model.addAttribute("result",1);
        }else {
            model.addAttribute("result",0);
        }

        return ViewConstant.CONTACTS;
    }
}
