package com.hilab.peoplemanager.repository;

import com.hilab.peoplemanager.domain.Person;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeopleManagerRepository {

  private final MongoTemplate mongoTemplate;

  public PeopleManagerRepository(final MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public List<Person> findAllPeople() {
    return mongoTemplate.findAll(Person.class);
  }

  public List<Person> findPerson(String id) {
    Query query = Query.query(Criteria.where("id").is(id));
    return mongoTemplate.find(query, Person.class);
  }

  public Person createPerson(Person person) {
    return mongoTemplate.save(person);
  };

  public Person updatePerson(Person person) {
    Query query = Query.query(Criteria.where("givenName").is(person.getGivenName()).and("familyName").is(person.getFamilyName()));
    return mongoTemplate.findAndReplace(query, person, FindAndReplaceOptions.options().upsert());
  };

  public void deletePerson(String id) {
    Query query = Query.query(Criteria.where("id").is(id));
    mongoTemplate.findAndRemove(query, Person.class);
  };
}
