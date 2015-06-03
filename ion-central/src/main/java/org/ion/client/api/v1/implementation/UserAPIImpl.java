package org.ion.client.api.v1.implementation;

import org.ion.client.api.v1.IONAPIBase;
import org.ion.client.api.v1.UserAPI;
import org.ion.client.domain.enumeration.SexType;
import org.ion.client.repository.ApplicationSessionRepository;
import org.ion.client.repository.UserDataRepository;
import org.ion.client.services.*;
import org.ion.client.domain.user.User;
import org.ion.client.services.util.UserCreationSpec;
import org.ion.client.services.util.UserDetail;
import org.ion.client.services.util.UserLogoutConfirmationSpec;
import org.ion.client.services.util.UserRegistrationSessionData;
import org.ion.client.services.util.UserRegistrationSessionStatus;
import org.ion.client.services.util.UserSession;
import org.ion.util.Tokenizer;
import org.ionexchange.v1.objects.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
@Controller
public class UserAPIImpl extends IONAPIBase implements UserAPI {
  private UserDataRepository _userDataRepository;
  private ApplicationSessionRepository _applicationSessionRepository;
  private AuthorizationService _authorizationService;
  private Tokenizer _tokenizer;

  public UserAPIImpl(UserDataRepository userDataRepository) {
    _userDataRepository = userDataRepository;
  }

  public UserAPIImpl() {
  }

  @Override
  public APIResponse<String> userLogin(APIRequest<UserLoginData> apiRequest) throws Exception {
    assert apiRequest != null;
    assert apiRequest.getData() != null;

    User user = _userDataRepository.getUserByUsername(apiRequest.getData().getUsername());
    if (user != null) {
      boolean hasLoginAuthority = _authorizationService.hasLoginAuthority(user, apiRequest.getData().getPassword());
      if (hasLoginAuthority) {
        UserSession userSession = new UserSession();
        String sessionId = _tokenizer.generateNewSessionId();
        userSession.setUserId(user.getId());
        userSession.setUserSessionId(sessionId);
        _applicationSessionRepository.setUserSession(userSession);
        return okResponse(userSession.getUserSessionId());
      } else {
        return failedResponse("Username and password do not match.");
      }
    } else {
      return failedResponse("Username is not identified.");
    }
  }

  //TODO data validation!
  @Override
  @RequestMapping()
  public APIResponse<Void> registerUser(APIRequest<UserRegistrationData> apiRequest) throws Exception {
    assert apiRequest != null;
    assert apiRequest.getData() != null;

    UserRegistrationSessionData userRegistrationSessionData = new UserRegistrationSessionData();
    String registrationToken = _tokenizer.generateNewRegistrationToken();
    userRegistrationSessionData.setToken(registrationToken);
    userRegistrationSessionData.setUserRegistrationData(apiRequest.getData());
    userRegistrationSessionData.setUserRegistrationSessionStatus(UserRegistrationSessionStatus.ACTIVE);
    _applicationSessionRepository.setUserRegistrationSession(userRegistrationSessionData);
    return okResponse();
  }

  @Override
  public APIResponse<Void> confirmUserRegistration(APIRequest<UserRegistrationConfirmationData> apiRequest) throws Exception {
    assert apiRequest != null;
    assert apiRequest.getData() != null;


    String token = apiRequest.getData().getSubmittedToken();
    UserRegistrationSessionData userRegistrationSessionData = _applicationSessionRepository.getUserRegistrationSession(token);
    if (userRegistrationSessionData.getUserRegistrationSessionStatus() == UserRegistrationSessionStatus.ACTIVE) {
      if (apiRequest.getData().getSubmittedToken().equals(userRegistrationSessionData.getToken())) {
        UserRegistrationData userRegistrationData = userRegistrationSessionData.getUserRegistrationData();
        User newUser = new User();
        newUser.setFirstname(userRegistrationData.getFirstName());
        newUser.setLastname(userRegistrationData.getLastName());
        newUser.setEmail(userRegistrationData.getEmail());

        org.ionexchange.v1.SexType exchangedSexType = userRegistrationData.getGender();
        switch (exchangedSexType) {
          case MALE:
            newUser.setGender(SexType.MALE);
            break;
          case FEMALE:
            newUser.setGender(SexType.FEMALE);
            break;
          default:
            throw new IOException("The sextype " + exchangedSexType + " is inappropriate.");
        }
        newUser.setPhonenumber(userRegistrationData.getPhoneNumber());
        _userDataRepository.upsertUser(newUser);
        return okResponse();
      } else {
        return failedResponse("Inputted token does not match");
      }
    } else if (userRegistrationSessionData.getUserRegistrationSessionStatus() == UserRegistrationSessionStatus.COMPLETED) {
      return failedResponse("The registration has been confirmed");
    } else if (userRegistrationSessionData.getUserRegistrationSessionStatus() == UserRegistrationSessionStatus.NA) {
      return failedResponse("The registration has been expired or not available");
    } else {
      return failedResponse("Registration confirmation is not available");
    }
  }

  @Override
  public APIResponse<Void> confirmUserLogout(APIRequest<UserLogoutData> apiRequest) throws Exception {
    assert apiRequest != null;
    assert apiRequest.getData() != null;

    UserLogoutConfirmationSpec userLogoutConfirmationSpec = new UserLogoutConfirmationSpec();
    _applicationSessionRepository.confirmUserLogout(apiRequest.getData().getSessionId());
    return okResponse();
  }

  @Override
  public APIResponse<UserDetail> retrieveUserDetail(APIRequest<UserDetailRequest> apiRequest) throws Exception {
    assert apiRequest != null;
    assert apiRequest.getData() != null;
    User user = _userDataRepository.getUserById(apiRequest.getData().getUserId());
    if (user != null) {
      //TODO mix data!
      return okResponse(new UserDetail());
    } else {
      return failedResponse("User is not found");
    }
  }
}
