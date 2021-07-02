package mx.kmmx.junit02.contact.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    public static final String CONSTANTE = "soy una constante";

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        System.out.println(CONSTANTE);
        this.firstName = validFirstName(firstName);
        this.lastName = validLastName(lastName);
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = validFirstName(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = validLastName(lastName);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) && Objects.equals(lastName, contact.lastName) && Objects.equals(phoneNumber, contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }

    private String validFirstName(String firstName){
        if(firstName == null || firstName.isBlank()){
            throw new RuntimeException("First Name Cannot be null");
        }

        // r4ul <--
        String regex = "^[0-9]*$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(firstName);

        if(matcher.matches()){
            throw new IllegalArgumentException("First Name Cannot be alphanumeric");
        }

        return firstName;
    }

    private String validLastName(String lastName){
        if(lastName == null || lastName.isBlank()){
            throw new IllegalArgumentException("Last Name Cannot be null");
        }
        return lastName;
    }
}
