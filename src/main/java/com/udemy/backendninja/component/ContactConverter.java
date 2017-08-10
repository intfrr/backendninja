package com.udemy.backendninja.component;

import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {

    public Contact convertContactModel2Contact(ContactModel contactModel){
        return new Contact(contactModel.getId(), contactModel.getFirstName(), contactModel.getLastName(), contactModel.getTelephone(), contactModel.getCity());
    }

    public ContactModel convertContact2ContactModel(Contact contact){

        return new ContactModel(contact.getId(), contact.getFirstName(), contact.getLastName(), contact.getTelephone(), contact.getCity());

    }

}
