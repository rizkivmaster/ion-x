package org.ion.client.api.v1;

import org.ion.client.domain.transaction.Transaction;

import java.util.List;

/**
 * // TODO Comment
 */
public class IncomingTransactionData {
  private List<Transaction> _transactionList;

  public IncomingTransactionData() {
  }

  public List<Transaction> getTransactionList() {
    return _transactionList;
  }

  public void setTransactionList(List<Transaction> transactionList) {
    _transactionList = transactionList;
  }
}
