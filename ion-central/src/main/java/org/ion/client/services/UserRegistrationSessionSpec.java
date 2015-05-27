package org.ion.client.services;

import org.ionexchange.v1.objects.UserRegistrationData;

/**
 * // TODO Comment
 */
public class UserRegistrationSessionSpec {
  private UserRegistrationData _userRegistrationData;
  private String _sessionId;

  public UserRegistrationSessionSpec() {
  }

  public UserRegistrationData getUserRegistrationData() {
    return _userRegistrationData;
  }

  public void setUserRegistrationData(UserRegistrationData userRegistrationData) {
    _userRegistrationData = userRegistrationData;
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }
}
