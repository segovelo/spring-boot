package com.example.springboot;

/**
 * 22 May 2021 12:29:17 @Javadoc TODO
 *
 * @author Sebastian Vergara Losada *
 */
import static org.assertj.core.api.Assertions.*;

import java.net.URL;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

  @LocalServerPort private int port;

  private URL base;

  @Autowired private TestRestTemplate template;

  @BeforeEach
  public void setUp() throws Exception {
    this.base = new URL("http://localhost:" + port);
  }

  @Test
  public void getGreetings() throws Exception {
    String fullURL = base.toString() + "/get-greetings";
    ResponseEntity<String> response = template.getForEntity(fullURL, String.class);
    assertThat(response.getBody()).isEqualTo("Hello !!! **** Greetings from Spring Boot! ****");
  }
}
