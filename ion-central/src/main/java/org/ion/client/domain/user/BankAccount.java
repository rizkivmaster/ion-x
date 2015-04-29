package org.ion.client.domain.user;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class BankAccount {
  private final String _id;
  private final String _providerId;
  private final String _providerName;
  private final String _realAccountId;

  public BankAccount(String id, String providerId, String providerName, String realAccountId) {
    _id = id;
    _providerId = providerId;
    _providerName = providerName;
    _realAccountId = realAccountId;
  }
}
