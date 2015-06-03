package org.ion.client.services.implementation;

import org.ion.client.domain.finance.IONSavingsAccount;
import org.ion.client.domain.transaction.TransactionProxy;
import org.ion.client.repository.UserPreferenceBypass;
import org.ion.client.repository.implementation.postgre.PostgreUserPreferenceBypass;
import org.ion.client.services.UserPreferenceService;

/**
 * // TODO Comment
 */
public class UserPreferenceServiceImpl implements UserPreferenceService {

  UserPreferenceBypass _userPreferenceBypass;

  @Override
  public IONSavingsAccount getDefaultSavingAccountByTransactionProxy(TransactionProxy transactionProxy) throws Exception {
    return null;  // TODO impl
  }
}
