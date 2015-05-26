package org.ion.client.controller;


/**
 * Created by rizkivmaster on 4/25/15.
 */


import org.ion.client.services.UserDataService;
import org.springframework.stereotype.Controller;

@Controller
public class IONMobileController {
  private static UserDataService _userDataService;

  public IONMobileController(UserDataService userDataService) {
    _userDataService = userDataService;
  }

  public IONMobileController() {
  }


  /*@RequestMapping(value= Routers.USER_REGISTRATION_CREATION,method=RequestMethod.POST)
  public @ResponseBody  UserRegistrationRequest createCustomer(@RequestBody UserRegistrationRequest request)
  {
    RegistrationCreationSpec registrationCreationSpec = new RegistrationCreationSpec.Builder()
        .setUsername(request.getUsername())
        .setFirstName(request.getFirstName())
        .setLastName(request.getLastName())
        .setEmail(request.getEmail())
        .setGender(request.getGender() == org.ionexchange.v1.SexType.FEMALE ? SexType.MALE: SexType.FEMALE)
        .setPhoneNumber(request.getPhoneNumber())
        .setAddress(request.getAddress())
        .createRegistrationCreationSpec();
    _userDataService.createNewUser(registrationCreationSpec);
    return request;
  }*/
/*
  @RequestMapping(value= "/createtext")
  public @ResponseBody String createCustomerText(@RequestParam(value="name", defaultValue="World") String name)
  {
    String response = String.format("Hello %s",name);
    return response;
  }*/
}
