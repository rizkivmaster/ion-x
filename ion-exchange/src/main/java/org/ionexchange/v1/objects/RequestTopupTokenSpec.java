package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class RequestTopupTokenSpec {
//  private String _bankAccountId;
  private String _userId;
  private String _bankAccountId;
  private String _sessionId;
//  private BankAccountProvider _provider;
//  private String _accountNumber;

  public RequestTopupTokenSpec() {
  }

  public String getUserId() {
    return _userId;
  }

  public void setUserId(String userId) {
    _userId = userId;
  }


  public String getBankAccountId() {
    return _bankAccountId;
  }

  public void setBankAccountId(String bankAccountId) {
    _bankAccountId = bankAccountId;
  }

  public String getSessionId() {
    return _sessionId;
  }

  public void setSessionId(String sessionId) {
    _sessionId = sessionId;
  }
}
