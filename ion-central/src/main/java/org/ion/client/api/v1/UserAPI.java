package org.ion.client.api.v1;

import org.ionexchange.v1.objects.*;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * // TODO Comment
 */
@Controller
public interface UserAPI {
  UserLoginConfirmationResponse confirmUserLogin(UserLoginConfirmationRequest userLoginConfirmationRequest) throws IOException;

  UserRegistrationCreationResponse createUserRegistration(UserRegistrationCreationRequest userRegistrationCreationRequest) throws IOException;

  UserRegistrationConfirmationResponse confirmUserRegistration(UserRegistrationConfirmationRequest userRegistrationConfirmationRequest) throws IOException;

  UserLogoutResponse confirmUserLogout(UserLogoutRequest userLogoutRequest) throws IOException;

  UserDetailRetrievalResponse retrieveUserDetail(UserDetailRetrievalRequest userDetailRetrievalRequest) throws IOException;

  AddUserContactResponse addUserContact(AddUserContactRequest addUserContactRequest) throws IOException;

  UserContactConfirmationResponse confirmUserContactInvitation(UserContactConfirmationRequest userContactConfirmationRequest) throws IOException;
}

