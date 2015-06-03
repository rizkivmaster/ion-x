package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class ToBankTransferCreationSpec {
  private String _userId;
  private String _savingAccountId;
  private String _bankAccountId;
  private long _amount;

  public ToBankTransferCreationSpec() {
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

  public long getAmount() {
    return _amount;
  }

  public void setAmount(long amount) {
    _amount = amount;
  }

  public String getBankAccountId() {
    return _bankAccountId;
  }

  public void setBankAccountId(String bankAccountId) {
    _bankAccountId = bankAccountId;
  }
}
