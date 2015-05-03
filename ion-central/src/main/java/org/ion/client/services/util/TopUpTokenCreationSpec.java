package org.ion.client.services.util;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class TopUpTokenCreationSpec {
  private long _amount;
  private long _accountId;

  public TopUpTokenCreationSpec(long amount, long accountId) {
    _amount = amount;
    _accountId = accountId;
  }

  public long getAmount() {
    return _amount;
  }

  public long getAccountId() {
    return _accountId;
  }
}
