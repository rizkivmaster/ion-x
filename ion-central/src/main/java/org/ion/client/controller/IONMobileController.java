package org.ion.client.controller;


/**
 * Created by rizkivmaster on 4/25/15.
 */


import org.ion.client.domain.enumeration.SexType;
import org.ion.client.services.UserDataService;
import org.ion.client.services.util.RegistrationCreationSpec;
import org.ionexchange.SpecRestURIConstants;
import org.ionexchange.UserRegistrationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IONMobileController {
  private static UserDataService _userDataService;

  public IONMobileController(UserDataService userDataService) {
    _userDataService = userDataService;
  }

  public IONMobileController() {
  }


  @RequestMapping(value= SpecRestURIConstants.CREATE_ACCOUNT,method=RequestMethod.POST)
  public @ResponseBody  UserRegistrationRequest createCustomer(@RequestBody UserRegistrationRequest request)
  {
    RegistrationCreationSpec registrationCreationSpec = new RegistrationCreationSpec.Builder()
        .setUsername(request.getUsername())
        .setFirstName(request.getFirstName())
        .setLastName(request.getLastName())
        .setEmail(request.getEmail())
        .setGender(request.getGender() == org.ionexchange.SexType.FEMALE ? SexType.MALE: SexType.FEMALE)
        .setPhoneNumber(request.getPhoneNumber())
        .setAddress(request.getAddress())
        .createRegistrationCreationSpec();
    _userDataService.createRegistration(registrationCreationSpec);
    return request;
  }

  @RequestMapping(value= "/createtext")
  public @ResponseBody String createCustomerText(@RequestParam(value="name", defaultValue="World") String name)
  {
    String response = String.format("Hello %s",name);
    return response;
  }
}
