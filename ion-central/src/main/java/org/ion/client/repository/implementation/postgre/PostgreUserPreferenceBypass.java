package org.ion.client.repository.implementation.postgre;

import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.repository.UserPreferenceBypass;

/**
 * // TODO Comment
 */
public class PostgreUserPreferenceBypass extends PostgreRepositoryBase implements UserPreferenceBypass {
  @Override
  public IONSavingsAccount getDefaultSavingAccountByTransactionProxy(TransactionProxy transactionProxy) throws Exception {
    return null;  // TODO impl
  }
}
