package org.ionexchange.v1.objects;

import org.ionexchange.v1.SexType;

/**
 * // TODO Comment
 */
public class UserRegistrationData {
  private String _username;
  private String _firstName;
  private String _lastName;
  private String _email;
  private SexType _gender;
  private String _phoneNumber;
  private String _address;

  public UserRegistrationData() {
  }

  public String getUsername() {
    return _username;
  }

  public void setUsername(String username) {
    _username = username;
  }

  public String getFirstName() {
    return _firstName;
  }

  public void setFirstName(String firstName) {
    _firstName = firstName;
  }

  public String getLastName() {
    return _lastName;
  }

  public void setLastName(String lastName) {
    _lastName = lastName;
  }

  public String getEmail() {
    return _email;
  }

  public void setEmail(String email) {
    _email = email;
  }

  public SexType getGender() {
    return _gender;
  }

  public void setGender(SexType gender) {
    _gender = gender;
  }

  public String getPhoneNumber() {
    return _phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    _phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return _address;
  }

  public void setAddress(String address) {
    _address = address;
  }

}
