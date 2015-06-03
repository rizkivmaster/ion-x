package org.ion.client.repository;

import org.ionexchange.v1.objects.TransactionView;
import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.domain.TransactionAlias;

import java.io.IOException;
import java.util.List;

/**
 * Created by rizkivmaster on 4/23/15.
 */

public interface TransactionRepository {
  /*
   * TopUp related service
   */

  TransactionAlias getTransactionAliasbyUsername(String username) throws IOException;

  TransactionAlias getTransactionAliasbyId(String id);

  TransactionProxy getTransactionProxybyId(String id);

  void createP2PTransactionGroup(TransactionAlias creatorAlias, TransactionAlias attendantAlias) throws IOException;

  TransactionProxy getP2PPartnerInGroupByTransactionId(String id);

  void createP2PTextTransaction(TransactionProxy transactionProxy, String text);

  List<TransactionView> getUnreadTransactions(TransactionAlias transactionAlias, int size, int skip);


}
