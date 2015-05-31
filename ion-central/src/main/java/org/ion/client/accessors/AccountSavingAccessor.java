package org.ion.client.accessors;

import org.ion.client.domain.transaction.IONSavingAccount;
import org.ion.client.domain.user.Account;

/**
 * // TODO Comment
 */
public interface AccountSavingAccessor {
  IONSavingAccount getSavingAccount(Account account);
  void upsertSavingAccount(IONSavingAccount IONSavingAccount);
}
