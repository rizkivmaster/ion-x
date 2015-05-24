package org.ion.client.services.util;

/**
 * Created by rizkivmaster on 4/24/15.
 */
public class UserRegistrationConfirmationSpec {
  private String _userId;
  private String _confirmationCode;

  public String getUserId() {
    return _userId;
  }

  public void setUserId(String userId) {
    _userId = userId;
  }

  public String getConfirmationCode() {
    return _confirmationCode;
  }

  public void setConfirmationCode(String confirmationCode) {
    _confirmationCode = confirmationCode;
  }
}
