package com.appsdeveloperblog.app.ws.mobileappws.exc.handlers;

import com.appsdeveloperblog.app.ws.mobileappws.model.reponse.ErrorMessage;
import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * This is a Java exception handler that returns a response entity with an internal server error
   * status code and the exception object as its body.
   *
   * @param ex The exception that was thrown and needs to be handled.
   * @param request The WebRequest object represents the current request being processed by the server.
   * It contains information about the request such as the HTTP method, headers, and parameters. It can
   * also be used to retrieve information about the server environment, such as the servlet context or
   * session. In this exception handler method, the Web
   * @return A ResponseEntity object is being returned with the Exception object, HttpHeaders, and
   * HttpStatus.INTERNAL_SERVER_ERROR as its parameters.
   */
  @ExceptionHandler(value = { Exception.class })
  public ResponseEntity<Object> handleAnyException(
    Exception ex,
    WebRequest request
  ) {
    String errorMessageDiscription = ex.getLocalizedMessage();
    if (errorMessageDiscription == null) {
      errorMessageDiscription = ex.toString();
    }
    ErrorMessage errorMessage = new ErrorMessage(
      new Date(),
      errorMessageDiscription
    );
    return new ResponseEntity<>(
      errorMessage,
      new HttpHeaders(),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }

  @ExceptionHandler(
    value = { NullPointerException.class, UserServiceException.class }
  )
  public ResponseEntity<Object> handleSpecificExceptions(
    Exception ex,
    WebRequest request
  ) {
    String errorMessageDiscription = ex.getLocalizedMessage();
    if (errorMessageDiscription == null) {
      errorMessageDiscription = ex.toString();
    }
    ErrorMessage errorMessage = new ErrorMessage(
      new Date(),
      errorMessageDiscription
    );
    return new ResponseEntity<>(
      errorMessage,
      new HttpHeaders(),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}
