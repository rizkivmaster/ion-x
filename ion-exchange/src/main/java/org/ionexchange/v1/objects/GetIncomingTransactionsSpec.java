package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class GetIncomingTransactionsSpec {
  private String _transactionAliasId;
  private int limit;
  private int skip;

  public GetIncomingTransactionsSpec() {
  }

  public String getTransactionAliasId() {
    return _transactionAliasId;
  }

  public void setTransactionAliasId(String transactionAliasId) {
    _transactionAliasId = transactionAliasId;
  }

  public int getLimit() {
    return limit;
  }

  public void setLimit(int limit) {
    this.limit = limit;
  }

  public int getSkip() {
    return skip;
  }

  public void setSkip(int skip) {
    this.skip = skip;
  }
}
