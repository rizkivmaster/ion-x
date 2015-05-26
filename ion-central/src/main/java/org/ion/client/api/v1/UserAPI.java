package org.ion.client.api.v1;

import org.ionexchange.v1.objects.*;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * // TODO Comment
 */
@Controller
public interface UserAPI {
  APIResponse<String> userLogin(APIRequest<UserLoginData> apiRequest) throws IOException;

  APIResponse<Void> registerUser(APIRequest<UserRegistrationData> apiRequest) throws IOException;

  APIResponse<Void> confirmUserRegistration(APIRequest<UserRegistrationConfirmationData> apiRequest) throws IOException;

  APIResponse<Void> confirmUserLogout(APIRequest<UserLogoutData> apiRequest) throws IOException;

  APIResponse<Void> retrieveUserDetail(APIRequest<UserDetailRequest> apiRequest) throws IOException;

  APIResponse<Void> addUserContact(APIRequest<AddUserContactData> apiRequest) throws IOException;

  APIResponse<Void> confirmUserContactInvitation(APIRequest<UserContactConfirmationData> apiRequest) throws IOException;
}

