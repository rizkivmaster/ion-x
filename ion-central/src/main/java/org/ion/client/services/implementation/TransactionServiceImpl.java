package org.ion.client.services.implementation;

import org.ion.client.accessors.AccountSavingAccessor;
import org.ion.client.accessors.AccountDataAccessor;
import org.ion.client.domain.transaction.IONSavingAccount;
import org.ion.client.domain.user.BankAccount;
import org.ion.client.services.BankAccountTransactionService;
import org.ion.client.services.TransactionService;

/**
 * // TODO Comment
 */
public class TransactionServiceImpl implements TransactionService {
  private final AccountDataAccessor _accountDataAccessor;
  private final AccountSavingAccessor _accountSavingAccessor;
  private final BankAccountTransactionService _bankAccountTransactionService;

  private final BankAccount _ionBankAccount;

  public TransactionServiceImpl(AccountDataAccessor accountDataAccessor, AccountSavingAccessor accountSavingAccessor, BankAccountTransactionService bankAccountTransactionService, BankAccount ionBankAccount) {
    _accountDataAccessor = accountDataAccessor;
    _accountSavingAccessor = accountSavingAccessor;
    _bankAccountTransactionService = bankAccountTransactionService;
    _ionBankAccount = ionBankAccount;
  }


  @Override
  public void reloadBalance(BankAccount srcBankAccount, IONSavingAccount dstIONSavingAccount, long amount) throws Exception {
    assert amount > 0;
    assert srcBankAccount!=null;
    assert dstIONSavingAccount !=null;
    //to where?
    _bankAccountTransactionService.transferP2P(srcBankAccount,_ionBankAccount, amount);
    dstIONSavingAccount.setAmount(dstIONSavingAccount.getAmount()+amount);
    _accountSavingAccessor.upsertSavingAccount(dstIONSavingAccount);

  }

  @Override
  public void transferP2P(IONSavingAccount srcIONSavingAccount, IONSavingAccount dstIONSavingAccount, long amount) throws Exception {
    assert amount>0;
    assert srcIONSavingAccount !=null;
    assert dstIONSavingAccount !=null;
    assert srcIONSavingAccount.getAmount()>amount;
    dstIONSavingAccount.setAmount(dstIONSavingAccount.getAmount()-amount);
    srcIONSavingAccount.setAmount(srcIONSavingAccount.getAmount()-amount);
    _accountSavingAccessor.upsertSavingAccount(srcIONSavingAccount);
    _accountSavingAccessor.upsertSavingAccount(dstIONSavingAccount);
  }

  @Override
  public void unloadBalance(IONSavingAccount srcIONSavingAccount, BankAccount dstBankAccount, long amount) throws Exception {
    assert amount>0;
    assert srcIONSavingAccount !=null;
    assert dstBankAccount!=null;
    assert srcIONSavingAccount.getAmount()>amount;
    //asumsi berhasil
    _bankAccountTransactionService.transferP2P(_ionBankAccount,dstBankAccount,amount);
    srcIONSavingAccount.setAmount(srcIONSavingAccount.getAmount()-amount);
    _accountSavingAccessor.upsertSavingAccount(srcIONSavingAccount);
  }
}
