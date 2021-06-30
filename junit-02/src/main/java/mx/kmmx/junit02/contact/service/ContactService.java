package mx.kmmx.junit02.contact.service;

import mx.kmmx.junit02.contact.model.Contact;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ContactService {

    Map<String, Contact> contactList = new HashMap<>();

    public void addContact(String firstName, String lastName, String phoneNumber){
        Contact contact = new Contact(firstName, lastName, phoneNumber);
        contactList.put(generateKey(contact),contact);
    }

    public Contact getContact(String key){
        return contactList.get(key);
    }

    private String generateKey(Contact contact){
        return String.format("%s-%s",contact.getFirstName().toLowerCase(),contact.getLastName().toLowerCase());
    }


}
