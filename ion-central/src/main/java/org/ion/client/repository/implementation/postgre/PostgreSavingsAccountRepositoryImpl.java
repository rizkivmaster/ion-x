package org.ion.client.repository.implementation.postgre;

import org.ion.client.domain.finance.BankAccount;
import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.repository.SavingsAccountRepository;
import org.ion.client.services.UserPreferenceService;

/**
 * // TODO Comment
 */
public class PostgreSavingsAccountRepositoryImpl extends PostgreRepositoryBase implements SavingsAccountRepository {
  @Override
  public IONSavingsAccount getSavingAccountById(String id) {
    return null;  // TODO impl
  }

  @Override
  public BankAccount getBankAccountById(String id) throws Exception {
    return null;  // TODO impl
  }

  @Override
  public void upsertSavingAccount(IONSavingsAccount IONSavingsAccount) {
    // TODO impl
  }

}
