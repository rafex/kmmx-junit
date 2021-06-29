package mx.kmmx.junit.contact;

public class Contact {
  private String firstName;
  private String lastName;
  private String phoneNumber;

  public Contact(final String firstName, final String lastName, final String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public void validateFirstName() {
    if (firstName == null) {
      throw new RuntimeException("First Name Cannot be null");
    }
  }

  public void validateLastName() {
    if (lastName == null) {
      throw new RuntimeException("Last Name Cannot be null");
    }
  }

  public void validatePhoneNumber() {
    if (phoneNumber.length() != 10) {
      throw new RuntimeException("Phone Number Should be 10 Digits Long");
    }
    if (!phoneNumber.matches("\\d+")) {
      throw new RuntimeException("Phone Number Contain only digits");
    }
    if (!phoneNumber.startsWith("0")) {
      throw new RuntimeException("Phone Number Should Start with 0");
    }
  }
}
