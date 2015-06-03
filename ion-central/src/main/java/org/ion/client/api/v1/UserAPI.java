package org.ion.client.api.v1;

import org.ion.client.services.util.UserDetail;
import org.ionexchange.v1.objects.*;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * // TODO Comment
 */
@Controller
public interface UserAPI {
  APIResponse<String> userLogin(APIRequest<UserLoginData> apiRequest) throws Exception;

  APIResponse<Void> registerUser(APIRequest<UserRegistrationData> apiRequest) throws Exception;

  APIResponse<Void> confirmUserRegistration(APIRequest<UserRegistrationConfirmationData> apiRequest) throws Exception;

  APIResponse<Void> confirmUserLogout(APIRequest<UserLogoutData> apiRequest) throws Exception;

  APIResponse<UserDetail> retrieveUserDetail(APIRequest<UserDetailRequest> apiRequest) throws Exception;

}

