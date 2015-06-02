package org.ion.client.domain.security;

/**
 * // TODO Comment
 */
public class BankAccountAuthority extends Authority {
  private String _bankAccountId;

  public BankAccountAuthority() {
  }

  public String getBankAccountId() {
    return _bankAccountId;
  }

  public void setBankAccountId(String bankAccountId) {
    _bankAccountId = bankAccountId;
  }
}
