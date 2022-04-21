package com.example.springboot;

import java.util.Objects;
import java.util.UUID;

public class Employee {

  private String id;
  private String firstName;
  private String lastName;
  private String role;

  Employee() {}
  
  Employee(String name) {
	   this.id = UUID.randomUUID().toString();
	   String[] parts = name.split(" ");
	    this.firstName = parts[0];
	    this.lastName = parts[1];
	    this.role = "Java Developer";
  }

  Employee(String name, String role) {
	   this.id = UUID.randomUUID().toString();
	   String[] parts = name.split(" ");
	    this.firstName = parts[0];
	    this.lastName = parts[1];
	    this.role = role;
	  }
  
  
  Employee(String firstName, String lastName, String role) {
	  this.id = UUID.randomUUID().toString();
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
  }

  public String getName() {
    return this.firstName + " " + this.lastName;
  }

  public void setName(String name) {
	  this.id = UUID.randomUUID().toString();
    String[] parts = name.split(" ");
    this.firstName = parts[0];
    this.lastName = parts[1];
  }

  public String getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getRole() {
    return this.role;
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

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Employee))
      return false;
    Employee employee = (Employee) o;
    return Objects.equals(this.id, employee.id) && Objects.equals(this.firstName, employee.firstName)
        && Objects.equals(this.lastName, employee.lastName) && Objects.equals(this.role, employee.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.firstName, this.lastName, this.role);
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + this.id + ", firstName='" + this.firstName + '\'' + ", lastName='" + this.lastName
        + '\'' + ", role='" + this.role + '\'' + '}';
  }
}