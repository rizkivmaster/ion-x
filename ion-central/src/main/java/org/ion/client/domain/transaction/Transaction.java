package org.ion.client.domain.transaction;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public abstract class Transaction {
  private final String _id;
  private final long _amount;

  public Transaction(String id, long amount) {
    _id = id;
    _amount = amount;
  }
}
