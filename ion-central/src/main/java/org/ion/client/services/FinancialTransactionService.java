package org.ion.client.services;

import org.ion.client.api.v1.TransactionProxy;
import org.ion.client.domain.transaction.IONSavingAccount;

/**
 * // TODO Comment
 */
public interface FinancialTransactionService {
  IONSavingAccount getDefaultSavingAccountByTransactionProxy(TransactionProxy transactionProxy);
  void transferP2P(IONSavingAccount srcIONSavingAccount, IONSavingAccount dstIONSavingAccount, long amount) throws  Exception;
}
