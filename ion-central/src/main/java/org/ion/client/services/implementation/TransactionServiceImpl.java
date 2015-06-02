package org.ion.client.services.implementation;

import org.ion.client.repository.AccountSavingAccessor;
import org.ion.client.repository.UserDataRepository;
import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.services.SavingsAccountTransactionService;
import org.ion.client.services.TransactionService;

/**
 * // TODO Comment
 */
public class TransactionServiceImpl implements TransactionService {
  private final UserDataRepository _userDataRepository;
  private final AccountSavingAccessor _accountSavingAccessor;
  private final SavingsAccountTransactionService _savingsAccountTransactionService;

  private final IONSavingsAccount _ionBankAccount;

  public TransactionServiceImpl(UserDataRepository userDataRepository, AccountSavingAccessor accountSavingAccessor, SavingsAccountTransactionService savingsAccountTransactionService, IONSavingsAccount ionBankAccount) {
    _userDataRepository = userDataRepository;
    _accountSavingAccessor = accountSavingAccessor;
    _savingsAccountTransactionService = savingsAccountTransactionService;
    _ionBankAccount = ionBankAccount;
  }


  @Override
  public void reloadBalance(IONSavingsAccount srcBankAccount, IONSavingsAccount dstIONSavingsAccount, long amount) throws Exception {
    assert amount > 0;
    assert srcBankAccount!=null;
    assert dstIONSavingsAccount !=null;
    //to where?
    _savingsAccountTransactionService.transferP2P(srcBankAccount,_ionBankAccount, amount);
    dstIONSavingsAccount.setBalance(dstIONSavingsAccount.getBalance() + amount);
    _accountSavingAccessor.upsertSavingAccount(dstIONSavingsAccount);

  }

  @Override
  public void transferP2P(IONSavingsAccount srcIONSavingsAccount, IONSavingsAccount dstIONSavingsAccount, long amount) throws Exception {
    assert amount>0;
    assert srcIONSavingsAccount !=null;
    assert dstIONSavingsAccount !=null;
    assert srcIONSavingsAccount.getBalance()>amount;
    dstIONSavingsAccount.setBalance(dstIONSavingsAccount.getBalance() - amount);
    srcIONSavingsAccount.setBalance(srcIONSavingsAccount.getBalance() - amount);
    _accountSavingAccessor.upsertSavingAccount(srcIONSavingsAccount);
    _accountSavingAccessor.upsertSavingAccount(dstIONSavingsAccount);
  }

  @Override
  public void unloadBalance(IONSavingsAccount srcIONSavingsAccount, IONSavingsAccount dstBankAccount, long amount) throws Exception {
    assert amount>0;
    assert srcIONSavingsAccount !=null;
    assert dstBankAccount!=null;
    assert srcIONSavingsAccount.getBalance()>amount;
    //asumsi berhasil
    _savingsAccountTransactionService.transferP2P(_ionBankAccount,dstBankAccount,amount);
    srcIONSavingsAccount.setBalance(srcIONSavingsAccount.getBalance() - amount);
    _accountSavingAccessor.upsertSavingAccount(srcIONSavingsAccount);
  }
}
