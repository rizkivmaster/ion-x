package org.ion.client.repository;

import org.ion.client.domain.finance.BankAccount;
import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.user.Account;

/**
 * // TODO Comment
 */
public interface SavingsAccountRepository {
  IONSavingsAccount getSavingAccountById(String id);
  BankAccount getBankAccountById(String id) throws Exception;
  void upsertSavingAccount(IONSavingsAccount IONSavingsAccount);
}
