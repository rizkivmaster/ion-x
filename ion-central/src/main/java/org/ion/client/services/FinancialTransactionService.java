package org.ion.client.services;

import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.domain.finance.IONSavingsAccount;

/**
 * // TODO Comment
 */
public interface FinancialTransactionService {
  IONSavingsAccount getDefaultSavingAccountByTransactionProxy(TransactionProxy transactionProxy);
  void transferP2P(IONSavingsAccount srcIONSavingsAccount, IONSavingsAccount dstIONSavingsAccount, long amount) throws  Exception;
}
