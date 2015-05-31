package org.ion.client.services;

import org.ion.client.domain.transaction.IONSavingAccount;
import org.ion.client.domain.user.BankAccount;

/**
 * // TODO Comment
 */
public interface SavingsAccountService {
  void moveMoneyInterSavingsAccount(IONSavingAccount srcIONSavingAccount,IONSavingAccount dstIONSavingsAccount, long amoun);
  void moveMoneyFromInternalToBank(IONSavingAccount srcIONSavingsAccount, BankAccount dstBankAccount);
  BankAccount getBankAccountById(String id);
  IONSavingAccount getDefaultIONSavingsAccountByUserId(String userId);
}
