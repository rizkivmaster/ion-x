package org.ion.client.services.util;

import org.ionexchange.v1.objects.UserRegistrationData;

/**
 * // TODO Comment
 */
public class UserRegistrationSessionSpec {
  private UserRegistrationData _userRegistrationData;
  private String _token;

  public UserRegistrationSessionSpec() {
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
}
