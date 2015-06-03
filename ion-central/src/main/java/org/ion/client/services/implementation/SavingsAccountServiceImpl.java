package org.ion.client.services.implementation;

import org.ion.client.domain.finance.BankAccount;
import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.services.SavingsAccountService;

/**
 * // TODO Comment
 */
public class SavingsAccountServiceImpl implements SavingsAccountService {
  @Override
  public void moveMoneyInterSavingsAccount(IONSavingsAccount srcIONSavingsAccount, IONSavingsAccount dstIONSavingsAccount, long amoun) throws Exception {
    // TODO impl
  }

  @Override
  public void moveMoneyFromInternalToBank(IONSavingsAccount srcIONSavingsAccount, BankAccount dstBankAccount) throws Exception {
    // TODO impl
  }
}
