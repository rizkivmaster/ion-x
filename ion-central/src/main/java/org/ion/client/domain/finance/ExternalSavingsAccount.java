package org.ion.client.domain.finance;

import org.ion.client.domain.enumeration.ExternalSavingsAccountProvider;

/**
 * // TODO Comment
 */
public abstract class ExternalSavingsAccount extends SavingsAccount {
  private ExternalSavingsAccountProvider _provider;

  protected ExternalSavingsAccount() {
  }

  public ExternalSavingsAccountProvider getProvider() {
    return _provider;
  }

  public void setProvider(ExternalSavingsAccountProvider provider) {
    _provider = provider;
  }
}
