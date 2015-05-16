package org.ion.client.services.implementation;

import org.ion.client.accessors.AccountSavingAccessor;
import org.ion.client.accessors.AccountDataAccessor;
import org.ion.client.domain.transaction.SavingAccount;
import org.ion.client.domain.user.Account;
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
  public void reloadBalance(BankAccount srcBankAccount, SavingAccount dstSavingAccount, long amount) throws Exception {
    assert amount > 0;
    assert srcBankAccount!=null;
    assert dstSavingAccount!=null;
    //to where?
    _bankAccountTransactionService.transferP2P(srcBankAccount,_ionBankAccount, amount);
    dstSavingAccount.setAmount(dstSavingAccount.getAmount()+amount);
    _accountSavingAccessor.upsertSavingAccount(dstSavingAccount);

  }

  @Override
  public void transferP2P(SavingAccount srcSavingAccount, SavingAccount dstSavingAccount, long amount) throws Exception {
    assert amount>0;
    assert srcSavingAccount!=null;
    assert dstSavingAccount!=null;
    assert srcSavingAccount.getAmount()>amount;
    dstSavingAccount.setAmount(dstSavingAccount.getAmount()-amount);
    srcSavingAccount.setAmount(srcSavingAccount.getAmount()-amount);
    _accountSavingAccessor.upsertSavingAccount(srcSavingAccount);
    _accountSavingAccessor.upsertSavingAccount(dstSavingAccount);
  }

  @Override
  public void unloadBalance(SavingAccount srcSavingAccount, BankAccount dstBankAccount, long amount) throws Exception {
    assert amount>0;
    assert srcSavingAccount!=null;
    assert dstBankAccount!=null;
    assert srcSavingAccount.getAmount()>amount;
    //asumsi berhasil
    _bankAccountTransactionService.transferP2P(_ionBankAccount,dstBankAccount,amount);
    srcSavingAccount.setAmount(srcSavingAccount.getAmount()-amount);
    _accountSavingAccessor.upsertSavingAccount(srcSavingAccount);
  }
}
