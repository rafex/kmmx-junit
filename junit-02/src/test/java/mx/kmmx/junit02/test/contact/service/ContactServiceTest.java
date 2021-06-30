package mx.kmmx.junit02.test.contact.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import mx.kmmx.junit02.contact.model.Contact;
import mx.kmmx.junit02.contact.service.ContactService;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    @DisplayName("Add new contact example")
    void addNewContactExample(){
        ContactService service = new ContactService();
        service.addContact("Raul","Gonzalez","5580995029");

        Contact expected = new Contact("Raul","Gonzalez","5580995029");
        String key = "raul-gonzalez";
        assertEquals(expected,service.getContact(key));
    }

}
