package com.example.springboot;

import java.net.URI;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.UriSpec;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.segovelo.api.core.web.response.Response;
import com.segovelo.api.core.web.response.ResponseHttpStatus;
import com.segovelo.api.core.web.util.CoreRestClient;


/**
 * 14 May 2021 23:21:27 @Javadoc TODO
 *
 * @author Segovelo *
 */
@RestController
public class HelloController {
	
	 private CoreRestClient restClient = new CoreRestClient();

  @GetMapping("/get-greetings")
  public String index() {
    return "Hello !!! **** Greetings from Spring Boot! ****";
  }

  @GetMapping("/get-fake-data")
  public Response getFakeData(@RequestHeader HttpHeaders requestHeaders) throws JsonProcessingException {
    //ResponseEntity<String> response = null;
    Employee employee = new Employee("Fernando Weibnest");
    URI uri = getEndpointURI("https://61004cc6bca46600171cf84a.mockapi.io/api-crud/v1/fakeData");
    Response response = restClient.callForResponse(uri, HttpMethod.GET, getHttpEntity(requestHeaders));
    //Response response = Response.assemble().build(ResponseHttpStatus.OK, employee);
   
    return response;
  }
  
	public static HttpHeaders populateHeaders(HttpHeaders httpHeaders) {
		final HttpHeaders headers = new HttpHeaders();
		headers.add("ACCEPT", "CONTENT_TYPE_VALUE");
		headers.add("CONTENT_TYPE", "CONTENT_TYPE_VALUE");
		headers.add("AUTHORIZATION", httpHeaders.getFirst("AUTHORIZATION"));
		headers.add("CORRELATION_ID", httpHeaders.getFirst("CORRELATION_ID"));
		headers.add("X_CORRELATION_ID", httpHeaders.getFirst("CORRELATION_ID"));
		// ...
		return headers;
	}
	
	public static HttpEntity<String> getHttpEntity(HttpHeaders httpHeaders){
		HttpHeaders headers = populateHeaders(httpHeaders);
		return new HttpEntity<>(headers);
	}

	public static HttpEntity<String> getHttpEntity(){
		return new HttpEntity<>(new HttpHeaders());
	}

	private static URI getEndpointURI(final String endpointUrl) {
		return UriComponentsBuilder.fromHttpUrl(endpointUrl)
				.build().encode()
				.toUri();
	}

}
