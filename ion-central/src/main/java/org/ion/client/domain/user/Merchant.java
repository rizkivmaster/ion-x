package org.ion.client.domain.user;

import org.ion.client.domain.enumeration.SexType;

import java.sql.Time;
import java.util.Date;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class Merchant extends Account {
  private final long _balance;
  private final String _companyAddress;
  private final String _companyName;


  public Merchant(String id, String username, String passwordHash, String firstName, String lastName, String email, Boolean isActive, SexType gender, String phoneNumber, Date dateCreated, long balance, String companyAddress, String companyName) {
    super(id, username, passwordHash, firstName, lastName, email, isActive, gender, phoneNumber, dateCreated);
    _balance = balance;
    _companyAddress = companyAddress;
    _companyName = companyName;
  }
}
