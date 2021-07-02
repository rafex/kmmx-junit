package mx.rafex.tutorial.junit.rest.servlet.person;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;

import dev.rafex.ether.rest.dtos.BaseResponseDto;
import dev.rafex.ether.rest.servlets.BaseServlet;
import mx.rafex.tutorial.junit.model.person.Person;
import mx.rafex.tutorial.junit.repository.person.impl.PersonRepository;
import mx.rafex.tutorial.junit.service.person.impl.PersonService;

@WebServlet(urlPatterns = { "/api/v01/person/*", "/api/v01/person" })
public class PersonServlet extends BaseServlet {
  
  private static final long serialVersionUID = 1350808025976733305L;
  
  private final Logger LOGGER = Logger.getLogger(this.getClass().getName());
  
  private final PersonService personService = new PersonService(new PersonRepository());
  
  @Override
  public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {

    if (request.getPathInfo() != null && request.getPathInfo().equals("/all")) {

      final List<Person> listAll = personService.listAll();

      if (listAll != null) {
        responseAsJson(response, new BaseResponseDto.Builder().code(HttpStatus.OK_200).object(listAll).build());
      } else {
        LOGGER.warning("Fail");
        responseAsJson(response, new BaseResponseDto.Builder().code(HttpStatus.INTERNAL_SERVER_ERROR_500).message("Fail").build());
      }

    }

  }
  
}
