package org.ion.client.api.v1;

import org.ion.client.domain.enumeration.SexType;
import org.ion.client.services.*;
import org.ion.client.services.util.UserCreationSpec;
import org.ion.client.services.util.UserRegistrationConfirmationSpec;
import org.ionexchange.v1.objects.*;
import org.ionexchange.v1.router.Routers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.AssertTrue;
import java.io.IOException;

/**
 * // TODO Comment
 */
@Controller
public class UserAPIImpl extends IONAPIBase implements UserAPI  {
  private UserDataService _userDataService;
  private ApplicationSessionService _applicationSessionService;
  private AuthorizationService _authorizationService;

  public UserAPIImpl(UserDataService userDataService) {
    _userDataService = userDataService;
  }

  public UserAPIImpl() {
  }

  @Override
  public APIResponse<String> userLogin(APIRequest<UserLoginData> apiRequest) throws IOException {
    assert apiRequest!=null;
    assert apiRequest.getData()!=null;
    User user = _userDataService.getUserByUsername(apiRequest.getData().getUsername());
    if(user!=null){
      boolean hasLoginAuthority = _authorizationService.hasLoginAuthority(user,apiRequest.getData().getPassword());
      if(hasLoginAuthority)
      {
        UserSession userSession = _applicationSessionService.createUserSession(user);
        return okResponse(userSession.getUserSessionId());
      }
      else
      {
        return failedResponse("Username and password do not match");
      }
    }
    else
    {
      return failedResponse("Username is not identified");
    }
  }

  @Override
  @RequestMapping()
  public APIResponse<Void> registerUser(APIRequest<UserRegistrationData> apiRequest) throws IOException {
    assert apiRequest!=null;
    assert apiRequest.getData()!=null;


    UserCreationSpec userCreationSpec = new UserCreationSpec();
    userCreationSpec.setFirstName(apiRequest.getData().getFirstName());
    userCreationSpec.setLastName(apiRequest.getData().getLastName());
    userCreationSpec.setAddress(apiRequest.getData().getAddress());
    userCreationSpec.setEmail(apiRequest.getData().getEmail());

    org.ionexchange.v1.SexType exchangedSexType = userRegistrationData.getGender();
    switch(exchangedSexType) {
      case MALE:
        userCreationSpec.setGender(SexType.MALE);
        break;
      case FEMALE:
        userCreationSpec.setGender(SexType.FEMALE);
        break;
      default:
        throw new IOException("The sextype " + exchangedSexType + " is inappropriate.");
    }
    userCreationSpec.setPhoneNumber(userRegistrationData.getPhoneNumber());
    userCreationSpec.setFirstName(userRegistrationData.getFirstName());
    _userDataService.createNewUser(userCreationSpec);

    return null;  // TODO impl
  }

  @Override
  public APIResponse<Void> confirmUserRegistration(APIRequest<UserRegistrationConfirmationData> apiRequest) throws IOException {
    return null;  // TODO impl
  }

  @Override
  public APIResponse<Void> confirmUserLogout(APIRequest<UserLogoutData> apiRequest) throws IOException {
    return null;  // TODO impl
  }

  @Override
  public APIResponse<Void> retrieveUserDetail(APIRequest<UserDetailRequest> apiRequest) throws IOException {
    return null;  // TODO impl
  }

  @Override
  public APIResponse<Void> addUserContact(APIRequest<AddUserContactData> apiRequest) throws IOException {
    return null;  // TODO impl
  }

  @Override
  public APIResponse<Void> confirmUserContactInvitation(APIRequest<UserContactConfirmationData> apiRequest) throws IOException {
    return null;  // TODO impl
  }

  @Override
  @RequestMapping(value= Routers.USER_REGISTRATION_CREATION,method = RequestMethod.POST)
  public @ResponseBody  UserRegistrationCreationResponse createUserRegistration(@RequestBody UserRegistrationData userRegistrationData) throws IOException {
    UserCreationSpec userCreationSpec = new UserCreationSpec();
    userCreationSpec.setFirstName(userRegistrationData.getFirstName());
    userCreationSpec.setLastName(userRegistrationData.getLastName());
    userCreationSpec.setAddress(userRegistrationData.getAddress());
    userCreationSpec.setEmail(userRegistrationData.getEmail());

    org.ionexchange.v1.SexType exchangedSexType = userRegistrationData.getGender();
    switch(exchangedSexType) {
      case MALE:
        userCreationSpec.setGender(SexType.MALE);
        break;
      case FEMALE:
        userCreationSpec.setGender(SexType.FEMALE);
        break;
      default:
        throw new IOException("The sextype " + exchangedSexType + " is inappropriate.");
    }
    userCreationSpec.setPhoneNumber(userRegistrationData.getPhoneNumber());
    userCreationSpec.setFirstName(userRegistrationData.getFirstName());
    _userDataService.createNewUser(userCreationSpec);
    return okResponse(UserRegistrationCreationResponse.class);  // TODO impl
  }

  @Override
  public UserRegistrationConfirmationResponse confirmUserRegistration(UserRegistrationConfirmationData userRegistrationConfirmationData) throws IOException {
    UserRegistrationConfirmationSpec userRegistrationConfirmationSpec = new UserRegistrationConfirmationSpec();
    userRegistrationConfirmationSpec.setUserId(userRegistrationConfirmationData.getUserId());
    userRegistrationConfirmationSpec.setConfirmationCode(userRegistrationConfirmationData.getConfirmationCode());
    _userDataService.confirmUserRegistration(userRegistrationConfirmationSpec);
    return okResponse(UserRegistrationConfirmationResponse.class);

  }

  @Override
  public UserLogoutResponse confirmUserLogout(UserLogoutData userLogoutData) throws IOException {
    UserLogoutConfirmationSpec userLogoutConfirmationSpec = new UserLogoutConfirmationSpec();
    userLogoutConfirmationSpec.setUserId(userLogoutData.getUserId());
    userLogoutConfirmationSpec.setSessionId(userLogoutData.getSessionId());
    _userDataService.confirmUserLogout(userLogoutConfirmationSpec);
    return okResponse(UserLogoutResponse.class);
  }

  @Override
  public UserDetailRetrievalResponse retrieveUserDetail(UserDetailRequest userDetailRequest) throws IOException {
    UserDetailSpec userDetailSpec = new UserDetailSpec();
    userDetailSpec.setUserId(userDetailRequest.getUserId());
    _userDataService.getUserDetail(userDetailSpec);
    return okResponse(UserDetailRetrievalResponse.class);
  }

  @Override
  public AddUserContactResponse addUserContact(AddUserContactData addUserContactData) throws IOException {
    AddUserContactSpec addUserContactSpec = new AddUserContactSpec();
    addUserContactSpec.setUserId(addUserContactData.getUserId());
    _userDataService.addUserContact(addUserContactSpec);
    return okResponse(AddUserContactResponse.class);
  }

  //TODO to implement!
  @Override
  public UserContactConfirmationResponse confirmUserContactInvitation(UserContactConfirmationData userContactConfirmationData) throws IOException {
    UserContactConfirmationSpec userContactConfirmationSpec = new UserContactConfirmationSpec();
    userContactConfirmationSpec.setUserContactInvitationId(userContactConfirmationData.getUserContactInvitationId());
    _userDataService.confirmUserContact(userContactConfirmationSpec);
    return okResponse(UserContactConfirmationResponse.class);
  }
}
