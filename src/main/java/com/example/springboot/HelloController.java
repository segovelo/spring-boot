package com.example.springboot;

import java.util.Collections;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;

/**
 * 14 May 2021 23:21:27 @Javadoc TODO
 *
 * @author Segovelo *
 */
@RestController
public class HelloController {

  @GetMapping("/get-greetings")
  public String index() {
    return "Hello !!! **** Greetings from Spring Boot! ****";
  }

  @GetMapping("/get-fake-data")
  public ResponseEntity<String> getFakeData() {
    ResponseEntity<String> response = null;

    WebClient client =
        WebClient.builder()
            .baseUrl("https://61004cc6bca46600171cf84a.mockapi.io/api-crud/v1")
            .defaultCookie("cookieKey", "cookieValue")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .defaultUriVariables(
                Collections.singletonMap(
                    "url", "https://61004cc6bca46600171cf84a.mockapi.io/api-crud/v1"))
            .build();

    UriSpec<RequestBodySpec> uriSpec = client.method(HttpMethod.GET);
    RequestBodySpec bodySpec = uriSpec.uri("/fakeData");
    System.out.println("\n\n\t  Full URL : " +  client.toString());
    return response;
  }
}
