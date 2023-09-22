package com.spring.board.eia.service;

import com.spring.board.eia.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.board.eia.entity.Person;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository repository;

    @Override
    public void createNewPerson(Person person) {
        repository.addPerson(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return repository.findPersons();
    }

    @Override
    public void deletePerson(String id) {
        Person person = repository.findPersonByPersonId(id);
        repository.deletePerson(person);
    }


    @Override
    public Person editPerson(int id, Person person) {
        return null;
    }
}
