package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class OpenP2PTransactionSpec {
  private String _creatorUsername;
  private String _attendantUsername;
  private String _sessionId;

  public OpenP2PTransactionSpec() {
  }

  public String getCreatorUsername() {
    return _creatorUsername;
  }

  public void setCreatorUsername(String creatorUsername) {
    _creatorUsername = creatorUsername;
  }

  public String getAttendantUsername() {
    return _attendantUsername;
  }

  public void setAttendantUsername(String attendantUsername) {
    _attendantUsername = attendantUsername;
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }
}
