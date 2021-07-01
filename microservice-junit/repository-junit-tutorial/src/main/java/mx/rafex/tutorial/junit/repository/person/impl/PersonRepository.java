package mx.rafex.tutorial.junit.repository.person.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import dev.rafex.ether.jdbc.connectors.IConnector;
import dev.rafex.ether.jdbc.connectors.impl.Connector;
import mx.rafex.tutorial.junit.model.person.Person;

public class PersonRepository {

  private final Logger LOGGER = Logger.getLogger(PersonRepository.class.getName());
  
  private final IConnector CONNECTOR = Connector.getInstance();
  
  private final Connection CONNECTION;

  public PersonRepository() {
    super();

  }
  
  public Person add(final Person person) {
    final StringBuilder query = new StringBuilder("INSERT INTO persontest (first_name,last_name,age) VALUES(?,?,?)");

    try (PreparedStatement preparedStatement = CONNECTION.prepareStatement(query.toString(), Statement.RETURN_GENERATED_KEYS)) {

      preparedStatement.setString(1, person.getFirstName());
      preparedStatement.setString(2, person.getLastName());
      preparedStatement.setInt(3, person.getAge());

      LOGGER.config(preparedStatement.toString());
      final int affectedRows = preparedStatement.executeUpdate();

      if (affectedRows == 0) {
        throw new SQLException("Data insert failed, no rows affected.");
      }

      try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
        if (resultSet.next()) {
          person.setId(resultSet.getInt(1));

          LOGGER.log(Level.CONFIG, person.toString());
          return person;
        } else {
          throw new SQLException("Data insert failed, no ID obtained.");
        }
      }

    } catch (final SQLException e) {
      LOGGER.log(Level.WARNING, "SQL Error", e);
    }

    return null;
  }

  public Person getById(final Integer id) {
    final StringBuilder query = new StringBuilder("SELECT id,first_name,last_name,age FROM persontest  WHERE id = ?");

    try (PreparedStatement preparedStatement = CONNECTION.prepareStatement(query.toString())) {

      preparedStatement.setInt(1, id);

      LOGGER.config(preparedStatement.toString());
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        Person person = null;
        while (resultSet.next()) {

          person = new Person(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getInt("age"));

        }
        return person;
      }
    } catch (final SQLException e) {
      LOGGER.log(Level.WARNING, "SQL Error", e);
    }

    return null;
  }
  
  public List<Person> getAll() {
    final StringBuilder query = new StringBuilder("SELECT id,first_name,last_name,age FROM persontest");

    try (PreparedStatement preparedStatement = CONNECTION.prepareStatement(query.toString())) {

      LOGGER.config(preparedStatement.toString());
      try (ResultSet resultSet = preparedStatement.executeQuery()) {
        final List<Person> all = new ArrayList<>();
        while (resultSet.next()) {

          Person person = null;
          person = new Person(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getInt("age"));
          all.add(person);
        }
        return all;
      }
    } catch (final SQLException e) {
      LOGGER.log(Level.WARNING, "SQL Error", e);
    }

    return null;
  }
  
}
