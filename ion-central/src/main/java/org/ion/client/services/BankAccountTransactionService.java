package org.ion.client.services;

import org.ion.client.domain.user.BankAccount;

/**
 * // TODO Comment
 */
public interface BankAccountTransactionService {
  void transferP2P(BankAccount srcBankAccount, BankAccount dstBankAccount, long amount) throws Exception;
}
