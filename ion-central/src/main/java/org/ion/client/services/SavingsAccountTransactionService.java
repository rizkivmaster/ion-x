package org.ion.client.services;

import org.ion.client.domain.finance.IONSavingsAccount;

/**
 * // TODO Comment
 */
public interface SavingsAccountTransactionService {
  void transferP2P(IONSavingsAccount srcBankAccount, IONSavingsAccount dstBankAccount, long amount) throws Exception;
}
