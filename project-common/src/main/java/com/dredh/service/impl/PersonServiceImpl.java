package com.dredh.service.impl;

import com.dredh.entity.Person;
import com.dredh.repository.PersonRepository;
import com.dredh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person findById(Integer id) {
        return personRepository.findOne(id);
    }
}
