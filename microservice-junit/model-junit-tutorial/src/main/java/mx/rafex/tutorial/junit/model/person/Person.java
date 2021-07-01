package mx.rafex.tutorial.junit.model.person;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
  
  private static final long serialVersionUID = 3489343293075839844L;

  private Integer id;
  private String firstName;
  private String lastName;
  private Integer age;

  public Person() {
    super();
  }
  
  /**
   * @param id
   * @param firstName
   * @param lastName
   * @param age
   */
  public Person(final Integer id, final String firstName, final String lastName, final Integer age) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
  
  /**
   * @param firstName
   * @param lastName
   * @param age
   */
  public Person(final String firstName, final String lastName, final Integer age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
  
  /**
   * @return the id
   */
  public Integer getId() {
    return id;
  }
  
  /**
   * @param id the id to set
   */
  public void setId(final Integer id) {
    this.id = id;
  }
  
  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }
  
  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }
  
  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }
  
  /**
   * @param lastName the lastName to set
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }
  
  /**
   * @return the age
   */
  public Integer getAge() {
    return age;
  }
  
  /**
   * @param age the age to set
   */
  public void setAge(final Integer age) {
    this.age = age;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(age, firstName, id, lastName);
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Person)) {
      return false;
    }
    final Person other = (Person) obj;
    return Objects.equals(age, other.age) && Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName);
  }
  
  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append("Person [id=");
    builder.append(id);
    builder.append(", firstName=");
    builder.append(firstName);
    builder.append(", lastName=");
    builder.append(lastName);
    builder.append(", age=");
    builder.append(age);
    builder.append("]");
    return builder.toString();
  }
  
}
