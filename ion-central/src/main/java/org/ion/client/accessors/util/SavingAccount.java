package org.ion.client.accessors.util;

/**
 * // TODO Comment
 */
public class SavingAccount {
  private String _id;
  private String _userid;
  private long _amount;

  public SavingAccount(String id, String userid, long amount) {
    _id = id;
    _userid = userid;
    _amount = amount;
  }

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  public String getUserid() {
    return _userid;
  }

  public void setUserid(String userid) {
    _userid = userid;
  }

  public long getAmount() {
    return _amount;
  }

  public void setAmount(long amount) {
    _amount = amount;
  }
}
