package org.ion.client.domain.finance;

/**
 * // TODO Comment
 */
public abstract class SavingsAccount {
  private String _id;
  private String _userId;
  private long balance;

  protected SavingsAccount() {
  }

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  public String getUserId() {
    return _userId;
  }

  public void setUserId(String userId) {
    _userId = userId;
  }

  public long getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }
}
