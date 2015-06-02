package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class ToBankTransferCreationSpec {
  private String _userId;
  private String _savingsAccountId;
  private long _amount;

  public ToBankTransferCreationSpec() {
  }

  public String getUserId() {
    return _userId;
  }

  public void setUserId(String userId) {
    _userId = userId;
  }

  public String getSavingsAccountId() {
    return _savingsAccountId;
  }

  public void setSavingsAccountId(String savingsAccountId) {
    _savingsAccountId = savingsAccountId;
  }

  public long getAmount() {
    return _amount;
  }

  public void setAmount(long amount) {
    _amount = amount;
  }
}
