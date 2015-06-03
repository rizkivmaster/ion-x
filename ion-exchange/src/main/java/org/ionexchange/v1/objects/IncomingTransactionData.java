package org.ionexchange.v1.objects;

import java.util.List;

/**
 * // TODO Comment
 */
public class IncomingTransactionData {
  private List<TransactionView> _transactionList;

  public IncomingTransactionData() {
  }

  public List<TransactionView> getTransactionList() {
    return _transactionList;
  }

  public void setTransactionList(List<TransactionView> transactionList) {
    _transactionList = transactionList;
  }
}
