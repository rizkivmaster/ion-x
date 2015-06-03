package org.ion.client.services.util;

import org.ion.client.domain.finance.BankAccount;

/**
 * // TODO Comment
 */
public class P2PTopupSessionSpec {
  private BankAccount _bankAccountTarget;
  private String _sessionId;

  public P2PTopupSessionSpec() {
  }

  public BankAccount getBankAccountTarget() {
    return _bankAccountTarget;
  }

  public void setBankAccountTarget(BankAccount bankAccountTarget) {
    _bankAccountTarget = bankAccountTarget;
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }
}
