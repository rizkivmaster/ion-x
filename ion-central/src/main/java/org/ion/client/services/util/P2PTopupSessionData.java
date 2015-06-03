package org.ion.client.services.util;

import org.ion.client.domain.finance.BankAccount;

/**
 * // TODO Comment
 */
public class P2PTopupSessionData {
  private String _token;
  private TopupSessionStatus _topupSessionStatus;
  private BankAccount _bankAccount;
  private String _sessionId;

  public P2PTopupSessionData() {
  }

  public String getToken() {
    return _token;
  }

  public void setToken(String token) {
    _token = token;
  }

  public TopupSessionStatus getTopupSessionStatus() {
    return _topupSessionStatus;
  }

  public void setTopupSessionStatus(TopupSessionStatus topupSessionStatus) {
    _topupSessionStatus = topupSessionStatus;
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }

  public BankAccount getBankAccount() {
    return _bankAccount;
  }

  public void setBankAccount(BankAccount bankAccount) {
    _bankAccount = bankAccount;
  }
}
