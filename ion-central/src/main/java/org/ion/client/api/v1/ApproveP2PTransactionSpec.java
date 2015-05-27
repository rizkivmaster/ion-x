package org.ion.client.api.v1;

import org.ion.client.services.P2PTransactionSessionStatus;

/**
 * // TODO Comment
 */
public class ApproveP2PTransactionSpec {
  private String _sessionId;

  public ApproveP2PTransactionSpec() {
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }
}
