package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    ContactConverter contactConverter;


    @Override
    public ContactModel addContact(ContactModel contactModel) {
        return contactConverter.convertContact2ContactModel(contactRepository.save(contactConverter.convertContactModel2Contact(contactModel)));
    }
}
