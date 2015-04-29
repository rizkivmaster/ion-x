package org.ion.client.domain.transaction;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public abstract class HorizontalTransaction extends Transaction {
  private final String _name;
  private final String _description;
  private final boolean _hasArrived;


  public HorizontalTransaction(String id, long amount, String name, String description, boolean hasArrived) {
    super(id, amount);
    _name = name;
    _description = description;
    _hasArrived = hasArrived;
  }
}
