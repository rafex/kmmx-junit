package mx.rafex.tutorial.junit.service.person.impl;

import java.util.List;

import mx.rafex.tutorial.junit.model.person.Person;
import mx.rafex.tutorial.junit.repository.person.impl.PersonRepository;

public class PersonService {
  
  private final PersonRepository personRepository;
  
  public PersonService(final PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person newPerson(final String firstName, final String lastName, final Integer age) {
    
    Person person = null;

    person = personRepository.add(new Person(firstName, lastName, age));

    return person;
  }

  public List<Person> listAll() {
    List<Person> all = null;

    all = personRepository.getAll();

    return all;
  }
  
}
