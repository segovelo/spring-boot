package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
* 14 May 2021 23:21:27
* @Javadoc TODO 
*
* @author Sebastian Vergara Losada  **/

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
