package org.ion.client.accessors;

import org.ion.client.domain.user.Account;
import org.ion.client.domain.user.Customer;
import org.joda.time.DateTime;

/**
 * // TODO Comment
 */
public interface AccountDataAccessor {
  void upsertCustomer(Account account);
  Account getCustomer(String id);
  Account getCustomerWithEmail(String email);
  Account getCustomerWithUsername(String username);
}
