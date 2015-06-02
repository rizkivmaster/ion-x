package org.ion.client.domain.user;

import org.ion.client.domain.enumeration.SexType;

/**
 * // TODO Comment
 */
public class User {
  private String _id;
  private String _firstname;
  private String _lastname;
  private SexType _gender;
  private String _email;
  private String _phonenumber;

  public User() {
  }

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  public String getFirstname() {
    return _firstname;
  }

  public void setFirstname(String firstname) {
    _firstname = firstname;
  }

  public String getLastname() {
    return _lastname;
  }

  public void setLastname(String lastname) {
    _lastname = lastname;
  }

  public SexType getGender() {
    return _gender;
  }

  public void setGender(SexType gender) {
    _gender = gender;
  }

  public String getEmail() {
    return _email;
  }

  public void setEmail(String email) {
    _email = email;
  }

  public String getPhonenumber() {
    return _phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    _phonenumber = phonenumber;
  }

  public String getNationalId() {
    return _nationalId;
  }

  public void setNationalId(String nationalId) {
    _nationalId = nationalId;
  }
}
