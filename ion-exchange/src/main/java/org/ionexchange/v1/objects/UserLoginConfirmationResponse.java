package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class UserLoginConfirmationResponse extends APIResponse {
  private String _username;
  private String _password;
  public UserLoginConfirmationResponse() {
  }

  public String getUsername() {
    return _username;
  }

  public void setUsername(String username) {
    _username = username;
  }

  public String getPassword() {
    return _password;
  }

  public void setPassword(String password) {
    _password = password;
  }
}
