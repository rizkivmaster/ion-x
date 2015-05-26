package org.ion.client.services;

import org.ion.client.services.util.UserRegistrationConfirmationSpec;

import java.io.IOException;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public interface ApplicationSessionService {
  TopupToken createTopupToken(ServiceSpec<TopupTokenCreationData> newTopupTokenCreationSpec);

  void createUserRegistration(ServiceSpec<UserRegistrationConfirmationSpec> userRegistrationConfirmationSpec);
  void createUserRegistration(ServiceSpec<UserRegistrationConfirmationSpec> userRegistrationConfirmationSpec);

  UserSession createUserSession(User user) throws IOException;
  void confirmUserLogout(ServiceSpec<UserLogoutConfirmationSpec userLogoutConfirmationSpec);

  void addUserContact(ServiceSpec<AddUserContactSpec addUserContactSpec);
  void confirmUserContact(ServiceSpec<UserContactConfirmationSpec userContactConfirmationSpec);

}
