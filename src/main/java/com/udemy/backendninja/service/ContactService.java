package com.udemy.backendninja.service;

import com.udemy.backendninja.model.ContactModel;

import java.util.List;

public interface ContactService {

    ContactModel addContact(ContactModel contactModel);

    List<ContactModel> listAllContacts();

    ContactModel findById(int id);

    void removeContact(int id);

}
