package org.ion.client.api.v1;

/**
 * // TODO Comment
 */
public class OpenP2PTransactionSpec {
  private String _creatorUsername;
  private String _attendantUsername;

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
}
