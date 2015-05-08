package org.ion.client.services.implementation;

import org.ion.client.accessors.AccountSavingAccessor;
import org.ion.client.accessors.AccountDataAccessor;
import org.ion.client.accessors.util.SavingAccount;
import org.ion.client.domain.user.Account;
import org.ion.client.domain.user.Customer;
import org.ion.client.services.TransactionService;

/**
 * // TODO Comment
 */
public class TransactionServiceImpl implements TransactionService {
  private final AccountDataAccessor _accountDataAccessor;
  private final AccountSavingAccessor _accountSavingAccessor;

  public TransactionServiceImpl(AccountDataAccessor accountDataAccessor, AccountSavingAccessor accountSavingAccessor) {
    _accountDataAccessor = accountDataAccessor;
    _accountSavingAccessor = accountSavingAccessor;
  }


  @Override
  public void topUpCustomerSaving(Account account, long amount) throws Exception {
    assert amount>0;
    assert account!=null;
    SavingAccount savingAccount = _accountSavingAccessor.getSavingAccount(account);
    savingAccount.setAmount(savingAccount.getAmount()+amount);
    _accountSavingAccessor.upsertSavingAccount(savingAccount);
  }

  @Override
  public void p2pTransfer(Account srcAccount, Account dstAccount, long amount) throws Exception {
    assert amount>0;
    assert srcAccount!=null;
    assert dstAccount!=null;
    SavingAccount savingAccountOrigin = _accountSavingAccessor.getSavingAccount(srcAccount);
    SavingAccount savingAccountDestination = _accountSavingAccessor.getSavingAccount(dstAccount);
    assert savingAccountOrigin.getAmount() - amount >= 0;
    savingAccountOrigin.setAmount(savingAccountOrigin.getAmount() - amount);
    savingAccountDestination.setAmount(savingAccountDestination.getAmount()+amount);
    _accountSavingAccessor.upsertSavingAccount(savingAccountOrigin);
    _accountSavingAccessor.upsertSavingAccount(savingAccountDestination);
  }
}
