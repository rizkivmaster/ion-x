package org.ion.client.services.util;

/**
 * // TODO Comment
 */
public class UserSession {
  private String _userSessionId;
  private String _userId;

  public UserSession() {
  }

  public String getUserSessionId() {
    return _userSessionId;
  }

  public void setUserSessionId(String userSessionId) {
    _userSessionId = userSessionId;
  }

  public String getUserId() {
    return _userId;
  }

  public void setUserId(String userId) {
    _userId = userId;
  }
}
