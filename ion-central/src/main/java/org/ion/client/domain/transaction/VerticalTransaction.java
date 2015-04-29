package org.ion.client.domain.transaction;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public abstract class VerticalTransaction extends Transaction {
  public VerticalTransaction(String id, long amount) {
    super(id, amount);
  }
}
