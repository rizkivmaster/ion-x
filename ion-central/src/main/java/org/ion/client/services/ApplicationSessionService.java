package org.ion.client.services;

import org.ion.client.services.util.P2PTopupSessionData;
import org.ion.client.services.util.P2PTopupSessionSpec;
import org.ion.client.services.util.P2PTransactionSessionData;
import org.ion.client.services.util.P2PTransactionSessionSpec;
import org.ion.client.services.util.UserLogoutConfirmationSpec;
import org.ion.client.services.util.UserRegistrationSessionData;
import org.ion.client.services.util.UserSession;

import java.io.IOException;

/**
 * Created by rizkivmaster on 4/23/15.
 */
//TODO formalize token: is an object that attached to a message to ensure the authenticity of the information
public interface ApplicationSessionService {

  void setUserRegistrationSession(UserRegistrationSessionData userRegistrationSessionData) throws IOException;

  UserRegistrationSessionData getUserRegistrationSession(String sessionId) throws IOException;

  void setUserSession(UserSession userSession) throws IOException;

  void confirmUserLogout(UserLogoutConfirmationSpec userLogoutConfirmationSpec) throws IOException;

  void createP2PTransactionSession(P2PTransactionSessionSpec spec) throws IOException;

  P2PTransactionSessionData getP2PTransactionSession(String sessionId) throws IOException;

  P2PTopupSessionData createTopupSession(P2PTopupSessionSpec spec) throws IOException;

  P2PTopupSessionData getTopupSession(String sessionId);
}
