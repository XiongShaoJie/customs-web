package com.customs.services;

import java.util.List;

import com.customs.entity.Person;

public interface IPersonService {
    public Person getById(Long id);

    public int addAge(int age, Long id) throws Exception;

    public List<Person> getAll();
}
