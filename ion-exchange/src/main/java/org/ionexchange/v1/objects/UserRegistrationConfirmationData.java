package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class UserRegistrationConfirmationData extends APIRequest{
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
