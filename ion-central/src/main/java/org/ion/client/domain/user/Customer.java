package org.ion.client.domain.user;

import org.ion.client.domain.enumeration.SexType;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/*the person who buys our products
     *TODO separate balance from here?
     */
public class Customer extends Account{
    private final long _balance;
    private final String _address;

  public Customer(String id, String username, String firstName, String lastName, String email, SexType gender, String phoneNumber, long balance, String address) {
    super(id, username, firstName, lastName, email, gender, phoneNumber);
    _balance = balance;
    _address = address;
  }

  public long getBalance() {
    return _balance;
  }

  public String getAddress() {
    return _address;
  }
}