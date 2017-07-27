package com.udemy.backendninja.service.impl;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

    @Override
    public List<Person> getListPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Arnau", 19));
        people.add(new Person("Mikel", 20));
        people.add(new Person("Eva", 21));
        people.add(new Person("Peter", 17));
        LOG.info("Hello from service - DATA " + people.toString());
        return people;
    }
}
