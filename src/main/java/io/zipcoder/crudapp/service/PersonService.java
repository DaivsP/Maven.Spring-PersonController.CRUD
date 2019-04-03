package io.zipcoder.crudapp.service;

import io.zipcoder.crudapp.model.Person;
import io.zipcoder.crudapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public Person createPerson(Person p){
        return repository.save(p);
    }

    public Person getPerson(Long id){
        return repository.findOne(id);
    }

    public Person updatePerson(Long id, Person p){
        Person originalPerson = repository.findOne(id);
        originalPerson.setFirstName(p.getFirstName());
        originalPerson.setLastName(p.getLastName());
        return repository.save(originalPerson);
    }

    public Boolean deletePerson(Long id){
        repository.delete(id);
        return true;
    }

    public List<Person> getPersonList(){
        return (List<Person>) repository.findAll();
    }
}
