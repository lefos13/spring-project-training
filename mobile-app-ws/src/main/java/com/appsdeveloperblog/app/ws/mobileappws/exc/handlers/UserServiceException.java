package com.appsdeveloperblog.app.ws.mobileappws.exc.handlers;

public class UserServiceException extends RuntimeException {

  //add serial version uid
  private static final long serialVersionUID = 1L;

  public UserServiceException(String message) {
    super(message);
  }
}
