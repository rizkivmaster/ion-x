package org.ion.client.services.util;

import org.ionexchange.v1.objects.UserRegistrationData;

/**
 * // TODO Comment
 */
public class UserRegistrationSessionData {
  private UserRegistrationData _userRegistrationData;
  private String _token;
  private UserRegistrationSessionStatus _userRegistrationSessionStatus;

  public UserRegistrationSessionData() {
  }

  public UserRegistrationData getUserRegistrationData() {
    return _userRegistrationData;
  }

  public void setUserRegistrationData(UserRegistrationData userRegistrationData) {
    _userRegistrationData = userRegistrationData;
  }

  public String getToken() {
    return _token;
  }

  public void setToken(String token) {
    _token = token;
  }

  public UserRegistrationSessionStatus getUserRegistrationSessionStatus() {
    return _userRegistrationSessionStatus;
  }

  public void setUserRegistrationSessionStatus(UserRegistrationSessionStatus userRegistrationSessionStatus) {
    _userRegistrationSessionStatus = userRegistrationSessionStatus;
  }
}
