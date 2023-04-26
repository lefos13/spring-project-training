package com.appsdeveloperblog.app.ws.mobileappws.ui.controller;

import com.appsdeveloperblog.app.ws.mobileappws.exc.handlers.UserServiceException;
import com.appsdeveloperblog.app.ws.mobileappws.model.reponse.UserRest;
import com.appsdeveloperblog.app.ws.mobileappws.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.mobileappws.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.mobileappws.userservice.UserService;
import jakarta.validation.Valid;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {

  Map<String, UserRest> users;

  // `@Autowired` is a Spring annotation that automatically injects an instance of the `UserService`
  // class into the `UserController` class. This means that the `UserController` can use the methods
  // and properties of the `UserService` without having to manually create an instance of it.
  @Autowired
  UserService userService;

  //GET COLLECTION OF USERS
  @GetMapping
  public String getUsers(
    @RequestParam(value = "page", defaultValue = "1") int page,
    @RequestParam(value = "limit", defaultValue = "50") int limit,
    @RequestParam(
      value = "sort",
      defaultValue = "ASC",
      required = false
    ) String sort
  ) {
    return "Page: " + page + ", limit: " + limit + ", sort: " + sort;
  }

  // GET USER BY ID
  @GetMapping(
    path = "/{userId}",
    produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
    }
  )
  public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
    if (true) {
      throw new UserServiceException("A user service exception has occurred");
    }

    if (users.containsKey(userId)) {
      return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  //POST CREATE USER
  @PostMapping(
    consumes = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
    },
    produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
    }
  )
  public ResponseEntity<UserRest> createUser(
    @Valid @RequestBody UserDetailsRequestModel userDetails
  ) {
    UserRest returnValue = userService.createUser(userDetails);
    return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
  }

  //PUT UPDATE USER
  /**
   * This function updates the details of a user and returns the updated user information.
   *
   * @param userId The ID of the user that needs to be updated. It is obtained from the path of the
   * URL.
   * @param userDetails It is a request body parameter of type UpdateUserDetailsRequestModel that
   * contains the updated details of a user. It is annotated with @RequestBody to indicate that the
   * parameter should be obtained from the request body. The @Valid annotation is used to validate the
   * request body against any constraints specified in the UpdateUser
   * @return The method is returning an object of type UserRest.
   */
  @PutMapping(
    path = "/{userId}",
    consumes = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
    },
    produces = {
      MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
    }
  )
  public UserRest updateUser(
    @PathVariable String userId,
    @Valid @RequestBody UpdateUserDetailsRequestModel userDetails
  ) {
    UserRest storedUserDetails = users.get(userId);

    storedUserDetails.setFirstName(userDetails.getFirstName());
    storedUserDetails.setLastName(userDetails.getLastName());

    users.put(userId, storedUserDetails);

    return storedUserDetails;
  }

  //DELETE USER
  /**
   * This function deletes a user with a specific ID from a collection of users.
   *
   * @param id The id parameter is a String variable that represents the unique identifier of a user
   * that needs to be deleted from the system. It is obtained from the URL path using the @PathVariable
   * annotation.
   * @return The method is returning a ResponseEntity object with no content and a HTTP status code of
   * 204 (No Content).
   */
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable String id) {
    users.remove(id);
    return ResponseEntity.noContent().build();
  }
}
