package io.zipcoder.crudapp.controller;

import io.zipcoder.crudapp.model.Person;
import io.zipcoder.crudapp.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    private PersonService service;

    public PersonController (PersonService service){
        this.service = service;
    }

    @PostMapping("/people/")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(service.createPerson(p), HttpStatus.CREATED);
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.getPerson(id), HttpStatus.OK);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person p){
        return new ResponseEntity<>(service.updatePerson(id, p), HttpStatus.OK);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> DeletePerson(@PathVariable Integer id){
        return new ResponseEntity<>(service.deletePerson(id), HttpStatus.OK);
    }
}