package mx.kmmx.junit02.test.contact.model;

import mx.kmmx.junit02.contact.model.Contact;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactTest {

    static Contact contact;
    static Contact expected;

    @BeforeAll
    //@BeforeEach
    public static void init(){
        System.out.println("BeforeAll method called");
        contact = new Contact("Raul", "Gonzalez", "5580888888");
        expected = new Contact("Raul", "Gonzalez", "5580888888");
    }

    @Test
    @DisplayName("Happy path")
    @Order(1)
    void happyPath(){
        System.setProperty("ENV", "PROD");

        Assumptions.assumeTrue("PROD".equals(System.getProperty("ENV")), "Test se ejecuta en prod");

        Assertions.assertEquals(expected,contact);
    }

    @Test
    @DisplayName("Valid firstName")
    //@RepeatedTest(5)
    @Order(3)
    void validFirstName(){
        Assertions.assertThrows(RuntimeException.class, () ->{
            contact = new Contact("","Gonzalez","5580080808");
        });
    }

    @Test
    @DisplayName("Valid numbers in firstName")
    @Order(2)
    void numbersFirstName(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact = new Contact("5555465", "", "");
        });
    }

    @Test
    @DisplayName("alphanumeric")
    void alphanumeric(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contact = new Contact("r4ul", "", "");
        });
    }
}
