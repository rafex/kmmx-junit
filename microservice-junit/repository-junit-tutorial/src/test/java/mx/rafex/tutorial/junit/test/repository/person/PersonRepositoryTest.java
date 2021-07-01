package mx.rafex.tutorial.junit.test.repository.person;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import mx.rafex.tutorial.junit.model.person.Person;
import mx.rafex.tutorial.junit.repository.person.impl.PersonRepository;

public class PersonRepositoryTest {

  @Test
  @Tag("integration")
  @DisplayName("Insert person in database")
  void insertPerson() {
    final PersonRepository repository = new PersonRepository();

    final Person person = new Person("Raul", "Gonzalez", 32);

    final Person insertPerson = repository.add(person);
    
    final Person getPerson = repository.getById(insertPerson.getId());
    
    Assertions.assertEquals(insertPerson, getPerson);
  }

  @Test
  @Tag("integration")
  @DisplayName("get all persona of database")
  void getAll() {
    final PersonRepository repository = new PersonRepository();

    final List<Person> all = repository.getAll();
    
    Assertions.assertFalse(all.isEmpty());
    
    for (final Person p : all) {
      Assertions.assertNotNull(p);
    }
  }

}
