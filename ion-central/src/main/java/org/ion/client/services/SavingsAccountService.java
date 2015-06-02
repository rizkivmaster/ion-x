package org.ion.client.services;

import org.ion.client.domain.finance.BankAccount;
import org.ion.client.domain.finance.IONSavingsAccount;

/**
 * // TODO Comment
 */
public interface SavingsAccountService {
  void moveMoneyInterSavingsAccount(IONSavingsAccount srcIONSavingsAccount,IONSavingsAccount dstIONSavingsAccount, long amoun);
  void moveMoneyFromInternalToBank(IONSavingsAccount srcIONSavingsAccount, BankAccount dstBankAccount);
  BankAccount getBankAccountById(String id);
  IONSavingsAccount getDefaultIONSavingsAccountByUserId(String userId);
}
