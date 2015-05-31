package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class RequestTopupTokenSpec {
//  private String _bankAccountId;
  private String _userId;
  private String _savingAccountId;
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


  public String getSavingAccountId() {
    return _savingAccountId;
  }

  public void setSavingAccountId(String savingAccountId) {
    _savingAccountId = savingAccountId;
  }
}
