package com.appsdeveloperblog.app.ws.mobileappws.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {

  @NotNull(message = "First name cannotbe null")
  @Size(min = 2, message = "First name must be at least 2 characters")
  private String firstName;

  @NotNull(message = "Last name cannotbe null")
  private String lastName;

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
}
