package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class UserRegistrationConfirmationData{
  private String _sessionId;
  private String _submittedToken;

  public UserRegistrationConfirmationData() {
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }

  public String getSubmittedToken() {
    return _submittedToken;
  }

  public void setSubmittedToken(String submittedToken) {
    _submittedToken = submittedToken;
  }
}
