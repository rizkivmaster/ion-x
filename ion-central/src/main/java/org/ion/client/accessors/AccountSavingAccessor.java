package org.ion.client.accessors;

import org.ion.client.domain.transaction.SavingAccount;
import org.ion.client.domain.user.Account;

/**
 * // TODO Comment
 */
public interface AccountSavingAccessor {
  SavingAccount getSavingAccount(Account account);
  void upsertSavingAccount(SavingAccount savingAccount);
}
