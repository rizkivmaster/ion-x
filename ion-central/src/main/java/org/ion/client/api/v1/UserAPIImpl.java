package org.ion.client.api.v1;

import org.ion.client.domain.enumeration.SexType;
import org.ion.client.services.AddUserContactSpec;
import org.ion.client.services.UserContactConfirmationSpec;
import org.ion.client.services.UserDataService;
import org.ion.client.services.UserDetailRetrievalSpec;
import org.ion.client.services.UserLoginConfirmationSpec;
import org.ion.client.services.UserLogoutConfirmationSpec;
import org.ion.client.services.util.UserRegistrationConfirmationSpec;
import org.ion.client.services.util.UserRegistrationCreationSpec;
import org.ionexchange.v1.objects.*;
import org.ionexchange.v1.router.Routers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * // TODO Comment
 */
@Controller
public class UserAPIImpl extends IONAPIBase implements UserAPI  {
  private static UserDataService _userDataService;

  public UserAPIImpl(UserDataService userDataService) {
    _userDataService = userDataService;
  }

  public UserAPIImpl() {
  }

  @Override
  public UserLoginConfirmationResponse confirmUserLogin(UserLoginConfirmationRequest userLoginConfirmationRequest) throws IOException {
    UserLoginConfirmationSpec userLoginConfirmationSpec = new UserLoginConfirmationSpec();
    userLoginConfirmationSpec.setUsername(userLoginConfirmationRequest.getUsername());
    userLoginConfirmationSpec.setPassword(userLoginConfirmationRequest.getPassword());
    _userDataService.confirmUserLogin(userLoginConfirmationSpec);
    return okResponse(UserLoginConfirmationResponse.class);
  }

  @Override
  @RequestMapping(value= Routers.USER_REGISTRATION_CREATION,method = RequestMethod.POST)
  public @ResponseBody  UserRegistrationCreationResponse createUserRegistration(@RequestBody UserRegistrationCreationRequest userRegistrationCreationRequest) throws IOException {
    UserRegistrationCreationSpec userRegistrationCreationSpec = new UserRegistrationCreationSpec();
    userRegistrationCreationSpec.setFirstName(userRegistrationCreationRequest.getFirstName());
    userRegistrationCreationSpec.setLastName(userRegistrationCreationRequest.getLastName());
    userRegistrationCreationSpec.setAddress(userRegistrationCreationRequest.getAddress());
    userRegistrationCreationSpec.setEmail(userRegistrationCreationRequest.getEmail());

    org.ionexchange.v1.SexType exchangedSexType = userRegistrationCreationRequest.getGender();
    switch(exchangedSexType) {
      case MALE:
        userRegistrationCreationSpec.setGender(SexType.MALE);
        break;
      case FEMALE:
        userRegistrationCreationSpec.setGender(SexType.FEMALE);
        break;
      default:
        throw new IOException("The sextype " + exchangedSexType + " is inappropriate.");
    }
    userRegistrationCreationSpec.setPhoneNumber(userRegistrationCreationRequest.getPhoneNumber());
    userRegistrationCreationSpec.setFirstName(userRegistrationCreationRequest.getFirstName());
    _userDataService.createUserRegistration(userRegistrationCreationSpec);
    return okResponse(UserRegistrationCreationResponse.class);  // TODO impl
  }

  @Override
  public UserRegistrationConfirmationResponse confirmUserRegistration(UserRegistrationConfirmationRequest userRegistrationConfirmationRequest) throws IOException {
    UserRegistrationConfirmationSpec userRegistrationConfirmationSpec = new UserRegistrationConfirmationSpec();
    userRegistrationConfirmationSpec.setUserId(userRegistrationConfirmationRequest.getUserId());
    userRegistrationConfirmationSpec.setConfirmationCode(userRegistrationConfirmationRequest.getConfirmationCode());
    _userDataService.confirmUserRegistration(userRegistrationConfirmationSpec);
    return okResponse(UserRegistrationConfirmationResponse.class);

  }

  @Override
  public UserLogoutResponse confirmUserLogout(UserLogoutRequest userLogoutRequest) throws IOException {
    UserLogoutConfirmationSpec userLogoutConfirmationSpec = new UserLogoutConfirmationSpec();
    userLogoutConfirmationSpec.setUserId(userLogoutRequest.getUserId());
    userLogoutConfirmationSpec.setSessionId(userLogoutRequest.getSessionId());
    _userDataService.confirmUserLogout(userLogoutConfirmationSpec);
    return okResponse(UserLogoutResponse.class);
  }

  @Override
  public UserDetailRetrievalResponse retrieveUserDetail(UserDetailRetrievalRequest userDetailRetrievalRequest) throws IOException {
    UserDetailRetrievalSpec userDetailRetrievalSpec = new UserDetailRetrievalSpec();
    userDetailRetrievalSpec.setUserId(userDetailRetrievalRequest.getUserId());
    _userDataService.getUserDetail(userDetailRetrievalSpec);
    return okResponse(UserDetailRetrievalResponse.class);
  }

  @Override
  public AddUserContactResponse addUserContact(AddUserContactRequest addUserContactRequest) throws IOException {
    AddUserContactSpec addUserContactSpec = new AddUserContactSpec();
    addUserContactSpec.setUserId(addUserContactRequest.getUserId());
    _userDataService.addUserContact(addUserContactSpec);
    return okResponse(AddUserContactResponse.class);
  }

  //TODO to implement!
  @Override
  public UserContactConfirmationResponse confirmUserContactInvitation(UserContactConfirmationRequest userContactConfirmationRequest) throws IOException {
    UserContactConfirmationSpec userContactConfirmationSpec = new UserContactConfirmationSpec();
    userContactConfirmationSpec.setUserContactInvitationId(userContactConfirmationRequest.getUserContactInvitationId());
    _userDataService.confirmUserContact(userContactConfirmationSpec);
    return okResponse(UserContactConfirmationResponse.class);
  }
}
