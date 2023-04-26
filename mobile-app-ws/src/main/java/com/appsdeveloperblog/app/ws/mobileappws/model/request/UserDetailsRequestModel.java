package com.appsdeveloperblog.app.ws.mobileappws.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {

  @NotNull(message = "First name cannotbe null")
  @Size(min = 2, message = "First name must be at least 2 characters")
  private String firstName;

  @NotNull(message = "Last name cannotbe null")
  private String lastName;

  @NotNull(message = "Email cannotbe null")
  @Email
  private String email;

  @NotNull(message = "Password cannotbe null")
  @Size(
    min = 8,
    max = 16,
    message = "Password must be between 8 and 16 characters"
  )
  private String password;

  //getters and setters
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
