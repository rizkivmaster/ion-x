package org.ion.client.domain.user;

import org.ion.client.domain.enumeration.SexType;
import org.joda.time.DateTime;

import java.sql.Time;
import java.util.Date;

/**
    *
    */
public abstract class Account{
        private final String _id;
        private final String _username;
        private final String _firstName;
        private final String _lastName;
        private final String _email;
        private final SexType _gender;
        private final String _phoneNumber;

  protected Account(String id, String username, String firstName, String lastName, String email, SexType gender, String phoneNumber) {
    _id = id;
    _username = username;
    _firstName = firstName;
    _lastName = lastName;
    _email = email;
    _gender = gender;
    _phoneNumber = phoneNumber;
  }

  public String getId() {
    return _id;
  }

  public String getUsername() {
    return _username;
  }

  public String getFirstName() {
    return _firstName;
  }

  public String getLastName() {
    return _lastName;
  }

  public String getEmail() {
    return _email;
  }

  public SexType getGender() {
    return _gender;
  }

  public String getPhoneNumber() {
    return _phoneNumber;
  }
}
