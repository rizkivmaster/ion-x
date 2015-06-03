package org.ion.client.repository;

import org.ion.client.services.util.P2PTopupSessionData;
import org.ion.client.services.util.P2PTopupSessionSpec;
import org.ion.client.services.util.P2PTransactionSessionData;
import org.ion.client.services.util.UserRegistrationSessionData;
import org.ion.client.services.util.UserSession;

import java.io.IOException;

/**
 * Created by rizkivmaster on 4/23/15.
 */
//TODO formalize token: is an object that attached to a message to ensure the authenticity of the information
public interface ApplicationSessionRepository {

  void setUserRegistrationSession(UserRegistrationSessionData userRegistrationSessionData) throws IOException;

  UserRegistrationSessionData getUserRegistrationSession(String sessionId) throws IOException;

  void setUserSession(UserSession userSession) throws IOException;

  void confirmUserLogout(String sessionId) throws IOException;

  void setP2PTransactionSession(P2PTransactionSessionData spec) throws IOException;

  P2PTransactionSessionData getP2PTransactionSession(String sessionId) throws IOException;

  void setTopupSession(P2PTopupSessionData spec) throws IOException;

  P2PTopupSessionData getTopupSession(String sessionId) throws IOException;
}
