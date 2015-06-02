package org.ion.client.services.util;

import org.ion.client.domain.finance.IONSavingsAccount;

/**
 * // TODO Comment
 */
public class P2PTopupSessionSpec {
  private IONSavingsAccount _bankAccountTarget;

  public P2PTopupSessionSpec() {
  }

  public IONSavingsAccount getBankAccountTarget() {
    return _bankAccountTarget;
  }

  public void setBankAccountTarget(IONSavingsAccount bankAccountTarget) {
    _bankAccountTarget = bankAccountTarget;
  }
}
