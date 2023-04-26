package com.appsdeveloperblog.app.ws.mobileappws.userservice;

import com.appsdeveloperblog.app.ws.mobileappws.Utils;
import com.appsdeveloperblog.app.ws.mobileappws.model.reponse.UserRest;
import com.appsdeveloperblog.app.ws.mobileappws.model.request.UserDetailsRequestModel;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

  Map<String, UserRest> users;
  Utils utils;

  //empty constructor
  public UserServiceImplementation() {}

  //constructor
  // This is a constructor for the `UserServiceImplementation` class that uses the `@Autowired`
  // annotation to inject an instance of the `Utils` class into the `UserServiceImplementation`
  // instance. This allows the `UserServiceImplementation` instance to use the methods and properties
  // of the `Utils` class without having to create a new instance of it.
  @Autowired
  public UserServiceImplementation(Utils utils) {
    this.utils = utils;
  }

  // add implemented methods here
  @Override
  public UserRest createUser(UserDetailsRequestModel userDetails) {
    UserRest user = new UserRest();
    user.setFirstName(userDetails.getFirstName());
    user.setLastName(userDetails.getLastName());
    user.setEmail(userDetails.getEmail());

    String userId = utils.generateUserId();
    user.setUserId(userId);

    if (users == null) users = new HashMap<>();
    users.put(userId, user);

    return user;
  }
}
