package org.ion.client.domain.finance;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class BankAccount extends SavingsAccount {
  private String _bankAccountNumber;

  public BankAccount() {
  }

  public String getBankAccountNumber() {
    return _bankAccountNumber;
  }

  public void setBankAccountNumber(String bankAccountNumber) {
    _bankAccountNumber = bankAccountNumber;
  }
}
