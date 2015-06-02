package org.ion.client.services.implementation;

import org.ion.client.repository.SessionRepository;
import org.ion.client.services.ApplicationSessionService;
import org.ion.client.services.util.P2PTopupSessionData;
import org.ion.client.services.util.P2PTopupSessionSpec;
import org.ion.client.services.util.P2PTransactionSessionData;
import org.ion.client.services.util.P2PTransactionSessionSpec;
import org.ion.client.services.util.UserLogoutConfirmationSpec;
import org.ion.client.services.util.UserRegistrationSessionData;
import org.ion.client.services.util.UserRegistrationSessionStatus;
import org.ion.client.services.util.UserSession;

import java.io.IOException;

/**
 * // TODO Comment
 */
public class ApplicationSessionServiceImpl implements ApplicationSessionService {
  private SessionRepository _sessionRepository;


  private static final int REGISTRATION_TTL = 3600;
  private static final int USER_SESSION_TTL = 3600;


  @Override
  public void setUserRegistrationSession(UserRegistrationSessionData userRegistrationSessionSpec) throws IOException {
    assert userRegistrationSessionSpec!=null;
    assert userRegistrationSessionSpec.getUserRegistrationData()!=null;
    assert userRegistrationSessionSpec.getToken()!=null && !"".equals(userRegistrationSessionSpec.getToken());

    UserRegistrationSessionData userRegistrationSessionData = new UserRegistrationSessionData();
    userRegistrationSessionData.setUserRegistrationData(userRegistrationSessionSpec.getUserRegistrationData());
    userRegistrationSessionData.setToken(userRegistrationSessionSpec.getToken());
    userRegistrationSessionData.setUserRegistrationSessionStatus(UserRegistrationSessionStatus.ACTIVE);
    _sessionRepository.set(userRegistrationSessionData.getToken(),REGISTRATION_TTL,userRegistrationSessionData);
  }

  @Override
  public UserRegistrationSessionData getUserRegistrationSession(String token) throws IOException {
    assert token!=null && !"".equals(token);

    UserRegistrationSessionData userRegistrationData = (UserRegistrationSessionData)_sessionRepository.get(token);

    if(userRegistrationData!=null)
    {
      return userRegistrationData;
    }
    else
    {
      userRegistrationData = new UserRegistrationSessionData();
      userRegistrationData.setUserRegistrationSessionStatus(UserRegistrationSessionStatus.NA);
      return userRegistrationData;
    }
  }


  @Override
  public void setUserSession(UserSession userSession) throws IOException {
    assert userSession!=null;
    assert userSession.getUserSessionId()!=null;
    assert userSession.getUserId()!=null;

    _sessionRepository.set(userSession.getUserSessionId(),USER_SESSION_TTL,userSession);
  }

  @Override
  public void confirmUserLogout(UserLogoutConfirmationSpec userLogoutConfirmationSpec) throws IOException {
    // TODO impl
  }

  @Override
  public void createP2PTransactionSession(P2PTransactionSessionSpec spec) throws IOException {
    // TODO impl
  }

  @Override
  public P2PTransactionSessionData getP2PTransactionSession(String sessionId) throws IOException {
    return null;  // TODO impl
  }

  @Override
  public P2PTopupSessionData createTopupSession(P2PTopupSessionSpec spec) throws IOException {
    return null;  // TODO impl
  }

  @Override
  public P2PTopupSessionData getTopupSession(String sessionId) {
    return null;  // TODO impl
  }


}
