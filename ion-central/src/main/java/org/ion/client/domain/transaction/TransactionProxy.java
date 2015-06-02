package org.ion.client.domain.transaction;

/**
 * // TODO Comment
 */
public class TransactionProxy {
  private String _id;
  private String _transactionGroupId;
  private String _aliasId;

  public TransactionProxy() {
  }

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  public String getTransactionGroupId() {
    return _transactionGroupId;
  }

  public void setTransactionGroupId(String transactionGroupId) {
    _transactionGroupId = transactionGroupId;
  }

  public String getAliasId() {
    return _aliasId;
  }

  public void setAliasId(String aliasId) {
    _aliasId = aliasId;
  }
}
