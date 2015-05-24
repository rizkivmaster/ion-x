package org.ion.client.services;

/**
 * // TODO Comment
 */
public class UserLogoutConfirmationSpec {
  private String _userId;
  private String _sessionId;

  public UserLogoutConfirmationSpec() {
  }

  public String getUserId() {
    return _userId;
  }

  public void setUserId(String userId) {
    _userId = userId;
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }
}
