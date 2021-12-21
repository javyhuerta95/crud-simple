package com.javyhuerta.crud2.services;

import com.javyhuerta.crud2.entities.Person;
import com.javyhuerta.crud2.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    PersonRepository personRepo;

    @Override
    public Person getPersonById(Long id) {
        return personRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Person> getAllPerson(Integer page, Integer size, Boolean enablePagination) {
        return personRepo.findAll(enablePagination ? PageRequest.of(page,size): Pageable.unpaged());
    }

    @Override
    public void savePerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void updatePerson(Long id, Person person) {
        Person p = personRepo.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("Persona no encontrada"));
        p.setName(person.getName());
        p.setLastName(p.getLastName());

        personRepo.save(p);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepo.deleteById(id);
    }
}
