package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class CreateP2PMoneyTransferSpec {
  private long _amount;
  private String _transactionProxyId;

  public CreateP2PMoneyTransferSpec() {
  }

  public long getAmount() {
    return _amount;
  }

  public void setAmount(long amount) {
    _amount = amount;
  }

  public String getTransactionProxyId() {
    return _transactionProxyId;
  }

  public void setTransactionProxyId(String transactionProxyId) {
    _transactionProxyId = transactionProxyId;
  }
}
