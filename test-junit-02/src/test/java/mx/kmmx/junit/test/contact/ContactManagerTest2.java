package mx.kmmx.junit.test.contact;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mx.kmmx.junit.contact.ContactManager;

public class ContactManagerTest2 {
  private static ContactManager contactManager;
  
  @BeforeAll
  public static void setup() {
    System.out.println("Instantiating Contact Manager before the Test Execution");
    contactManager = new ContactManager();
  }

  @Test
  @DisplayName("Should Create Contact")
  public void shouldCreateContact() {
    contactManager.addContact("John", "Doe", "0123456789");
    assertFalse(contactManager.getAllContacts().isEmpty());
    assertEquals(1, contactManager.getAllContacts().size());
  }

  @Test
  @DisplayName("Should Not Create Contact When First Name is Null")
  public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
    final ContactManager contactManager = new ContactManager();
    Assertions.assertThrows(RuntimeException.class, () -> {
      contactManager.addContact(null, "Doe", "0123456789");
    });
  }

  @Test
  @DisplayName("Should Not Create Contact When Last Name is Null")
  public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
    final ContactManager contactManager = new ContactManager();
    Assertions.assertThrows(RuntimeException.class, () -> {
      contactManager.addContact("John", null, "0123456789");
    });
  }

  @Test
  @DisplayName("Should Not Create Contact When Phone Number is Null")
  public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
    final ContactManager contactManager = new ContactManager();
    Assertions.assertThrows(RuntimeException.class, () -> {
      contactManager.addContact("John", "Doe", null);
    });
  }
}
