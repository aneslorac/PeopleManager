package com.hilab.peoplemanager.controller;

import com.hilab.peoplemanager.domain.Person;
import com.hilab.peoplemanager.service.PeopleManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/peoplemanager/person")
public class PeopleManagerController {

  private PeopleManagerService service;
  PeopleManagerController(PeopleManagerService service) {
    this.service = service;
  }

  @ResponseStatus(value = HttpStatus.OK)
  @PostMapping
  public ResponseEntity<Person> createPerson(@Valid @RequestBody Person person) {
    Person createdPerson = service.addPerson(person);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(createdPerson.getId())
        .toUri();
    return ResponseEntity.created(location).body(createdPerson);
  }

  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping
  public ResponseEntity<List<Person>> readPeople(@RequestParam(value = "id", required = false) String id) {
    if (id != null) {
      return ResponseEntity.ok(service.getPerson(id));
    }
    return ResponseEntity.ok(service.getAllPeople());
  }

  @ResponseStatus(value = HttpStatus.OK)
  @PutMapping(value = "/{id}")
  public ResponseEntity updatePerson(@PathVariable String id, @Valid @RequestBody Person person) {
    Person updatedPerson = service.updatePerson(person);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(updatedPerson.getId())
        .toUri();
    return ResponseEntity.created(location).body(updatedPerson);
  }

  @ResponseStatus(value = HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  public ResponseEntity deletePerson(@PathVariable String id) {
    service.deletePerson(id);
    return ResponseEntity.noContent().build();
  }
}
