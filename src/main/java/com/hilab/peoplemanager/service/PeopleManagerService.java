package com.hilab.peoplemanager.service;

import com.hilab.peoplemanager.domain.Person;
import com.hilab.peoplemanager.repository.PeopleManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleManagerService {

  PeopleManagerRepository repository;

  public PeopleManagerService(PeopleManagerRepository repository) {
    this.repository = repository;
  }

  public List<Person> getAllPeople() {
    return repository.findAllPeople();
  }

  public List<Person> getPerson(String id) {
    return repository.findPerson(id);
  }

  public Person addPerson(Person person) {
    return repository.createPerson(person);
  }

  public void deletePerson(String id) {
    repository.deletePerson(id);
  }

  public Person updatePerson(Person person) {
    return repository.updatePerson(person);
  }
}
