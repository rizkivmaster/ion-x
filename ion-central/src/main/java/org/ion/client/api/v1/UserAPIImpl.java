package org.ion.client.api.v1;

import org.ion.client.domain.enumeration.SexType;
import org.ion.client.services.*;
import org.ion.client.services.util.UserCreationSpec;
import org.ionexchange.v1.objects.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return failedResponse("Username and password do not match.");
      }
    }
    else
    {
      return failedResponse("Username is not identified.");
    }
  }

  //TODO data validation!
  @Override
  @RequestMapping()
  public APIResponse<Void> registerUser(APIRequest<UserRegistrationData> apiRequest) throws IOException {
    assert apiRequest!=null;
    assert apiRequest.getData()!=null;

    UserRegistrationSessionSpec userRegistrationSessionSpec = new UserRegistrationSessionSpec();
    userRegistrationSessionSpec.setSessionId(userRegistrationSessionSpec.getSessionId());
    userRegistrationSessionSpec.setUserRegistrationData(apiRequest.getData());
    _applicationSessionService.createUserRegistrationSession(userRegistrationSessionSpec);
    return okResponse();
  }

  @Override
  public APIResponse<Void> confirmUserRegistration(APIRequest<UserRegistrationConfirmationData> apiRequest) throws IOException {
    assert apiRequest!=null;
    assert apiRequest.getData()!=null;


    String sessionId = apiRequest.getData().getSessionId();
    UserRegistrationSessionData userRegistrationSessionData = _applicationSessionService.getUserRegistrationSession(sessionId);
    if(userRegistrationSessionData.getUserRegistrationSessionStatus()==UserRegistrationSessionStatus.ACTIVE) {
      if (apiRequest.getData().getSubmittedToken().equals(userRegistrationSessionData.getToken())) {
        UserRegistrationData userRegistrationData = userRegistrationSessionData.getUserRegistrationData();
        UserCreationSpec userCreationSpec = new UserCreationSpec();
        userCreationSpec.setFirstName(userRegistrationData.getFirstName());
        userCreationSpec.setLastName(userRegistrationData.getLastName());
        userCreationSpec.setAddress(userRegistrationData.getAddress());
        userCreationSpec.setEmail(userRegistrationData.getEmail());

        org.ionexchange.v1.SexType exchangedSexType = userRegistrationData.getGender();
        switch (exchangedSexType) {
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
        return okResponse();
      } else {
        return failedResponse("Inputted token does not match");
      }
    }
    else if(userRegistrationSessionData.getUserRegistrationSessionStatus()==UserRegistrationSessionStatus.COMPLETED){
      return failedResponse("The registration has been confirmed");
    }
    else if(userRegistrationSessionData.getUserRegistrationSessionStatus()==UserRegistrationSessionStatus.DEAD){
      return failedResponse("The registration has been expired or not available");
    }
    else
    {
      return failedResponse("Registration confirmation is not available");
    }
  }

  @Override
  public APIResponse<Void> confirmUserLogout(APIRequest<UserLogoutData> apiRequest) throws IOException {
    assert apiRequest!=null;
    assert apiRequest.getData()!=null;

    UserLogoutConfirmationSpec userLogoutConfirmationSpec = new UserLogoutConfirmationSpec();
    userLogoutConfirmationSpec.setSessionId(apiRequest.getData().getSessionId());
    userLogoutConfirmationSpec.setUserId(apiRequest.getData().getUserId());
    _applicationSessionService.confirmUserLogout(userLogoutConfirmationSpec);
    return okResponse();
  }

  @Override
  public APIResponse<UserDetail> retrieveUserDetail(APIRequest<UserDetailRequest> apiRequest) throws IOException {
    assert apiRequest!=null;
    assert apiRequest.getData()!=null;
    User user = _userDataService.getUserById(apiRequest.getData().getUserId());
    if(user!=null){
      //TODO mix data!
      return okResponse(new UserDetail());
    }
    else
    {
      return failedResponse("User is not found");
    }
  }
}
