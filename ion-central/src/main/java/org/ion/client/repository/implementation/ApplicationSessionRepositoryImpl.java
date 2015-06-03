package org.ion.client.repository.implementation;

import org.ion.client.repository.SessionRepository;
import org.ion.client.repository.ApplicationSessionRepository;
import org.ion.client.services.util.P2PTopupSessionData;
import org.ion.client.services.util.P2PTransactionSessionData;
import org.ion.client.services.util.UserRegistrationSessionData;
import org.ion.client.services.util.UserRegistrationSessionStatus;
import org.ion.client.services.util.UserSession;

import java.io.IOException;

/**
 * // TODO Comment
 */
public class ApplicationSessionRepositoryImpl implements ApplicationSessionRepository {
  private SessionRepository _sessionRepository;


  private static final int REGISTRATION_TTL = 3600;
  private static final int USER_SESSION_TTL = 3600;
  private static final int P2P_TRANSACTION_TTL = 3600;
  private static final int P2P_TOPUP_TTL = 3600;


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
  public void confirmUserLogout(String sessionId) throws IOException {
    assert sessionId!=null && sessionId.isEmpty();

    _sessionRepository.delete(sessionId);
  }

  @Override
  public void setP2PTransactionSession(P2PTransactionSessionData p2PTransactionSessionData) throws IOException {
    assert p2PTransactionSessionData!=null;
    assert p2PTransactionSessionData.getSessionId()!=null;

    _sessionRepository.set(p2PTransactionSessionData.getSessionId(),P2P_TRANSACTION_TTL,p2PTransactionSessionData);
  }

  @Override
  public P2PTransactionSessionData getP2PTransactionSession(String sessionId) throws IOException {
    assert sessionId!=null;

    P2PTransactionSessionData p2PTransactionSessionData = (P2PTransactionSessionData)_sessionRepository.get(sessionId);
    return p2PTransactionSessionData;
  }


  @Override
  public void setTopupSession(P2PTopupSessionData p2PTopupSessionData) throws IOException {
    assert p2PTopupSessionData!=null;
    assert p2PTopupSessionData.getSessionId()!=null;

    _sessionRepository.set(p2PTopupSessionData.getSessionId(), P2P_TOPUP_TTL,p2PTopupSessionData);
  }

  @Override
  public P2PTopupSessionData getTopupSession(String sessionId) throws IOException{
    assert sessionId!=null;

    P2PTopupSessionData p2PTopupSessionData = (P2PTopupSessionData) _sessionRepository.get(sessionId);
    return p2PTopupSessionData;
  }

}
