package com.spring.board.eia.service;


import java.util.List;
import com.spring.board.eia.entity.Person;
public interface PersonService {
    void createNewPerson(Person person);
    List<Person> getAllPersons();
    void deletePerson(String id);
    Person editPerson(int id,Person person);
}
