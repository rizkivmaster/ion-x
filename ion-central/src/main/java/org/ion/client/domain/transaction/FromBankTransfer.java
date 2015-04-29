package org.ion.client.domain.transaction;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class FromBankTransfer extends VerticalTransaction {
  private final String refNumber;
  private final boolean _hasSent;

  public FromBankTransfer(String id, long amount, String refNumber, boolean hasSent) {
    super(id, amount);
    this.refNumber = refNumber;
    _hasSent = hasSent;
  }
}
