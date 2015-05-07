package org.ion.client.accessors;

import org.ion.client.domain.user.Customer;
import org.joda.time.DateTime;

/**
 * // TODO Comment
 */
public interface CustomerDataAccessor {
  void upsertCustomer(Customer customer);
  Customer getCustomer(String UUID);
  Customer getCustomerWithEmail(String email);
  Customer getCustomerWithUsername(String username);
}
