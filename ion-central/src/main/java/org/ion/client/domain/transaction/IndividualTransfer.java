package org.ion.client.domain.transaction;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class IndividualTransfer extends HorizontalTransaction {
  private final String _accountId;

  public IndividualTransfer(String id, long amount, String name, String description, boolean hasArrived, String accountId) {
    super(id, amount, name, description, hasArrived);
    _accountId = accountId;
  }
}
