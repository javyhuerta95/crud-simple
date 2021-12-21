package com.javyhuerta.crud2.services;

import com.javyhuerta.crud2.entities.Person;
import org.springframework.data.domain.Page;

public interface PersonService {
    Person getPersonById(Long id);
    Page<Person> getAllPerson(Integer page, Integer size, Boolean enablePagination);
    void savePerson(Person person);
    void updatePerson(Long id, Person person);
    void deletePersonById(Long id);
}
