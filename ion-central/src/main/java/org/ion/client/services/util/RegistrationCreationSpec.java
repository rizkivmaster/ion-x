package org.ion.client.services.util;

import org.ion.client.domain.enumeration.SexType;

import java.io.Serializable;

/**
 * Created by rizkivmaster on 4/24/15.
 */
public class RegistrationCreationSpec implements Serializable {
  private String _username;
  private String _password;
  private String _firstName;
  private String _lastName;
  private String _email;
  private SexType _gender;
  private String _phoneNumber;
  private String _address;


  public RegistrationCreationSpec(String username, String firstName, String lastName, String email, SexType gender, String phoneNumber, String address) {
    _username = username;
    _firstName = firstName;
    _lastName = lastName;
    _email = email;
    _gender = gender;
    _phoneNumber = phoneNumber;
    _address = address;
  }

  public RegistrationCreationSpec() {
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

  public String getAddress() {
    return _address;
  }

  public String getPassword() {
    return _password;
  }

  @Override
  public String toString() {
    return _username+" "+_firstName;
  }

  public static class Builder {
    private String _username;
    private String _firstName;
    private String _lastName;
    private String _email;
    private SexType _gender;
    private String _phoneNumber;
    private String _address;

    public Builder setUsername(String username) {
      _username = username;
      return this;
    }

    public Builder setFirstName(String firstName) {
      _firstName = firstName;
      return this;
    }

    public Builder setLastName(String lastName) {
      _lastName = lastName;
      return this;
    }

    public Builder setEmail(String email) {
      _email = email;
      return this;
    }

    public Builder setGender(SexType gender) {
      _gender = gender;
      return this;
    }

    public Builder setPhoneNumber(String phoneNumber) {
      _phoneNumber = phoneNumber;
      return this;
    }

    public Builder setAddress(String address) {
      _address = address;
      return this;
    }

    public RegistrationCreationSpec createRegistrationCreationSpec() {
      return new RegistrationCreationSpec(_username, _firstName, _lastName, _email, _gender, _phoneNumber, _address);
    }
  }

}
