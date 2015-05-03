package org.ion.admin.domain;

import org.ion.client.domain.enumeration.SexType;
import org.ion.client.domain.user.Account;
import org.joda.time.DateTime;

import java.sql.Time;
import java.util.Date;

public class StoreManager extends Account {

  public StoreManager(String id, String username, String passwordHash, String firstName, String lastName, String email, Boolean isActive, SexType gender, String phoneNumber, DateTime dateCreated) {
    super(id, username, passwordHash, firstName, lastName, email, isActive, gender, phoneNumber, dateCreated);
  }
}