package org.ion.client.domain.transaction;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public abstract class Transaction {
  private String _id;
  private String _transactionProxyId;

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  public String getTransactionProxyId() {
    return _transactionProxyId;
  }

  public void setTransactionProxyId(String transactionProxyId) {
    _transactionProxyId = transactionProxyId;
  }
}
