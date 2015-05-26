package org.ion.client.api.v1;

import org.ion.client.services.UserDataService;
import org.ionexchange.v1.objects.*;
import org.ionexchange.v1.router.Routers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * // TODO Comment
 *//*
@Controller
public class UserAPIMockImpl extends IONAPIBase  {
  private static UserDataService _userDataService;

  public UserAPIMockImpl(UserDataService userDataService) {
    _userDataService = userDataService;
  }

  public UserAPIMockImpl() {
  }

  @RequestMapping(value= Routers.USER_REGISTRATION_CREATION,method = RequestMethod.POST)
  public @ResponseBody
  UserRegistrationCreationResponse createNewUser(@RequestBody UserRegistrationCreationRequest userRegistrationCreationRequest) throws IOException{
    return okResponse(UserRegistrationCreationResponse.class);
  }

  @RequestMapping(value= "/createtextuser")
  public @ResponseBody String createCustomerText(@RequestParam(value = "name", defaultValue = "World") String name) {
    String response = String.format("Hellooox %s",name);
    return response;
  }

}
*/