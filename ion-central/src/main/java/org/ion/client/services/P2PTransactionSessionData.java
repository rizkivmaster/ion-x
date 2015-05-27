package org.ion.client.services;

/**
 * // TODO Comment
 */
public class P2PTransactionSessionData {
  private String _id;
  private String _creatorAliasId;
  private String _attendantAliasId;
  private P2PTransactionSessionStatus _status;

  public P2PTransactionSessionData() {
  }

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
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
}
