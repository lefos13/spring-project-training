package com.appsdeveloperblog.app.ws.mobileappws.userservice;

import com.appsdeveloperblog.app.ws.mobileappws.model.reponse.UserRest;
import com.appsdeveloperblog.app.ws.mobileappws.model.request.UserDetailsRequestModel;

//define new interface
public interface UserService {
  UserRest createUser(UserDetailsRequestModel userDetails);
}
