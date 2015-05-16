package org.ion.client.domain.user;

import org.ion.client.domain.enumeration.SexType;
import org.joda.time.DateTime;

import java.sql.Time;
import java.util.Date;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class Merchant extends Account {
  private final long _balance;
  private final String _companyAddress;
  private final String _companyName;


  public Merchant(String id, String username, String firstName, String lastName, String email, SexType gender, String phoneNumber, long balance, String companyAddress, String companyName) {
    super(id, username, firstName, lastName, email, gender, phoneNumber);
    _balance = balance;
    _companyAddress = companyAddress;
    _companyName = companyName;
  }
}
