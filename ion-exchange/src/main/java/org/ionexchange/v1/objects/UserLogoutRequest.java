package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class UserLogoutRequest {
  private String _userId;
  private String _sessionId;

  public UserLogoutRequest() {
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
