package org.ionexchange.v0;


import org.ionexchange.v1.SexType;

/**
 * Created by rizkivmaster on 4/27/15.
 */
public class UserRegistrationRequest {
  private String _username;
  private String _firstName;
  private String _lastName;
  private String _email;
  private SexType _gender;
  private String _phoneNumber;
  private String _address;

  public UserRegistrationRequest() {
  }

  public UserRegistrationRequest(String username, String firstName, String lastName, String email, SexType gender, String phoneNumber, String address) {
    _username = username;
    _firstName = firstName;
    _lastName = lastName;
    _email = email;
    _gender = gender;
    _phoneNumber = phoneNumber;
    _address = address;
  }

  public void setUsername(String username) {
    _username = username;
  }

  public void setFirstName(String firstName) {
    _firstName = firstName;
  }

  public void setLastName(String lastName) {
    _lastName = lastName;
  }

  public void setEmail(String email) {
    _email = email;
  }

  public void setGender(SexType gender) {
    _gender = gender;
  }

  public void setPhoneNumber(String phoneNumber) {
    _phoneNumber = phoneNumber;
  }

  public void setAddress(String address) {
    _address = address;
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

    public UserRegistrationRequest createUserRegistrationRequest() {
      return new UserRegistrationRequest(_username, _firstName, _lastName, _email, _gender, _phoneNumber, _address);
    }
  }
}
