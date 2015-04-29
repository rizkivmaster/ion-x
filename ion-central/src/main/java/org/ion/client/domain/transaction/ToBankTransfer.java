package org.ion.client.domain.transaction;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class ToBankTransfer extends VerticalTransaction {
  private final String _bankAccountId;
  private final boolean _hasSent;

  public ToBankTransfer(String id, long amount, String bankAccountId, boolean hasSent) {
    super(id, amount);
    _bankAccountId = bankAccountId;
    _hasSent = hasSent;
  }
}
