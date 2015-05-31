package org.ion.client.services;

import org.ion.client.domain.user.BankAccount;

/**
 * // TODO Comment
 */
public class P2PTopupSessionSpec {
  private BankAccount _bankAccountTarget;

  public P2PTopupSessionSpec() {
  }

  public BankAccount getBankAccountTarget() {
    return _bankAccountTarget;
  }

  public void setBankAccountTarget(BankAccount bankAccountTarget) {
    _bankAccountTarget = bankAccountTarget;
  }
}
