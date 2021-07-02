package mx.rafex.tutorial.junit.test.rest.servlet.person;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PersonServletIntegrationTest {

  static HttpClient httpClient;

  @BeforeAll
  public static void init() {
    httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
  }
  
  @Test
  void getAll() throws Exception {

    final String uri = "http://localhost:8080/api/v01/person/all";
    
    final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).GET().build();

    final HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    
    // print status code
    Assertions.assertEquals(200, response.statusCode());

    // print response body
    Assertions.assertNotNull(response.body());
  }

}
