package mx.rafex.tutorial.junit.test.service.person;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.rafex.tutorial.junit.model.person.Person;
import mx.rafex.tutorial.junit.repository.person.impl.PersonRepository;
import mx.rafex.tutorial.junit.service.person.impl.PersonService;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  @Mock
  PersonRepository personRepository;

  @InjectMocks
  PersonService personService;
  
  @Test
  @Tag("mock")
  @DisplayName("Add new person in service")
  void newPerson() {
    final Person person = new Person("Raul", "Gonzalez", 32);
    final Person personResult = new Person(1, "Raul", "Gonzalez", 32);
    Mockito.when(personRepository.add(person)).thenReturn(personResult);
    
    final Person service = personService.newPerson("Raul", "Gonzalez", 32);
    
    Assertions.assertEquals(personResult, service);
    
  }
  
}
