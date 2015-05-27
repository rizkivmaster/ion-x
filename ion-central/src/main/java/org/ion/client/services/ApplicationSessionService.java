package org.ion.client.services;

import java.io.IOException;

/**
 * Created by rizkivmaster on 4/23/15.
 */
//TODO formalize token: is an object that attached to a message to ensure the authenticity of the information
public interface ApplicationSessionService {

  void createUserRegistrationSession(UserRegistrationSessionSpec userRegistrationSessionSpec) throws IOException;

  UserRegistrationSessionData getUserRegistrationSession(String sessionId) throws IOException;

  UserSession createUserSession(User user) throws IOException;

  void confirmUserLogout(UserLogoutConfirmationSpec userLogoutConfirmationSpec) throws IOException;

  void createP2PTransactionSession(P2PTransactionSessionSpec spec) throws IOException;

  P2PTransactionSessionData getP2PTransactionSession(String sessionId) throws IOException;
}
