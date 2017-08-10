package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.component.ContactConverter;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.repository.ContactRepository;
import com.udemy.backendninja.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ContactModel> listAllContacts() {
        List<ContactModel> contactsList = new ArrayList<>();
        for (Contact contact : contactRepository.findAll()){
            contactsList.add(contactConverter.convertContact2ContactModel(contact));
        }
        return contactsList;
    }
}
