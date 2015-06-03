package org.ion.client.services.util;

/**
 * // TODO Comment
 */
public class P2PTransactionSessionData {
  private String _creatorAliasId;
  private String _attendantAliasId;
  private P2PTransactionSessionStatus _status;
  private String _sessionId;

  public P2PTransactionSessionData() {
  }

  public String getCreatorAliasId() {
    return _creatorAliasId;
  }

  public void setCreatorAliasId(String creatorAliasId) {
    _creatorAliasId = creatorAliasId;
  }

  public String getAttendantAliasId() {
    return _attendantAliasId;
  }

  public void setAttendantAliasId(String attendantAliasId) {
    _attendantAliasId = attendantAliasId;
  }

  public P2PTransactionSessionStatus getStatus() {
    return _status;
  }

  public void setStatus(P2PTransactionSessionStatus status) {
    _status = status;
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }
}
