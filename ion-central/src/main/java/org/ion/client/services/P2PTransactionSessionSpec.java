package org.ion.client.services;

/**
 * // TODO Comment
 */
public class P2PTransactionSessionSpec {
  private String _creatorAliasId;
  private String _attendantAliasId;
  private String _sessionId;

  public P2PTransactionSessionSpec() {
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

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }
}
