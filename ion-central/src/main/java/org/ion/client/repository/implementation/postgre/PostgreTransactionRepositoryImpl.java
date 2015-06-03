package org.ion.client.repository.implementation.postgre;

import org.ion.client.domain.TransactionAlias;
import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.repository.TransactionRepository;
import org.ion.client.services.UserPreferenceService;
import org.ionexchange.v1.objects.TransactionView;

import java.io.IOException;
import java.util.List;

/**
 * // TODO Comment
 */
public class PostgreTransactionRepositoryImpl extends PostgreRepositoryBase implements TransactionRepository {
  @Override
  public TransactionAlias getTransactionAliasbyUsername(String username) throws IOException {
    return null;  // TODO impl
  }

  @Override
  public TransactionAlias getTransactionAliasbyId(String id) {
    return null;  // TODO impl
  }

  @Override
  public TransactionProxy getTransactionProxybyId(String id) {
    return null;  // TODO impl
  }

  @Override
  public void createP2PTransactionGroup(TransactionAlias creatorAlias, TransactionAlias attendantAlias) throws IOException {
    // TODO impl
  }

  @Override
  public TransactionProxy getP2PPartnerInGroupByTransactionId(String id) {
    return null;  // TODO impl
  }

  @Override
  public void createP2PTextTransaction(TransactionProxy transactionProxy, String text) {
    // TODO impl
  }

  @Override
  public List<TransactionView> getUnreadTransactions(TransactionAlias transactionAlias, int size, int skip) {
    return null;  // TODO impl
  }

}
