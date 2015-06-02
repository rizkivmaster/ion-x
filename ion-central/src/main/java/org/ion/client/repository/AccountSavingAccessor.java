package org.ion.client.repository;

import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.user.Account;

/**
 * // TODO Comment
 */
public interface AccountSavingAccessor {
  IONSavingsAccount getSavingAccount(Account account);
  void upsertSavingAccount(IONSavingsAccount IONSavingsAccount);
}
