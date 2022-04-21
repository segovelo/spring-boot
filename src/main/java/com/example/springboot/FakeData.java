package com.example.springboot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/** 
* 16 Apr 2022 00:15:27
* @Javadoc TODO 
*
* @author Segovelo  **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FakeData {
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("checkbox")
	private boolean checkbox;
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public boolean isCheckbox() {
		return checkbox;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCheckbox(boolean checkbox) {
		this.checkbox = checkbox;
	}
	@Override
	public String toString() {
		return "FakeData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", checkbox=" + checkbox
				+ "]";
	}
}
