package org.ion.client.services;

import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.domain.finance.IONSavingsAccount;

/**
 * // TODO Comment
 */
public interface UserPreferenceService {
  IONSavingsAccount getDefaultSavingAccountByTransactionProxy(TransactionProxy transactionProxy) throws Exception;
}
