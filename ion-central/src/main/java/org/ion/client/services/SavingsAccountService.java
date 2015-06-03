package org.ion.client.services;

import org.ion.client.domain.finance.BankAccount;
import org.ion.client.domain.finance.IONSavingsAccount;

/**
 * // TODO Comment
 */
public interface SavingsAccountService {
  void moveMoneyInterSavingsAccount(IONSavingsAccount srcIONSavingsAccount,IONSavingsAccount dstIONSavingsAccount, long amoun) throws Exception;
  void moveMoneyFromInternalToBank(IONSavingsAccount srcIONSavingsAccount, BankAccount dstBankAccount) throws Exception;
}
