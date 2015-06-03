package org.ion.client.repository;

import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.transaction.TransactionProxy;

/**
 * // TODO Comment
 */
public interface UserPreferenceBypass {
  IONSavingsAccount getDefaultSavingAccountByTransactionProxy(TransactionProxy transactionProxy) throws Exception;
}
