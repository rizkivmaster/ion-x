package org.ion.client.services.util;

import org.ion.client.domain.user.Customer;

/**
 * Created by rizkivmaster on 4/25/15.
 */
public class CustomerReadDetailResult {
  private final Customer _customer;

  public CustomerReadDetailResult(Customer customer) {
    _customer = customer;
  }

  public Customer getCustomer() {
    return _customer;
  }
}
