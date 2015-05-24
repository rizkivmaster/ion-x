package org.ionexchange.v1.objects;

/**
 * // TODO Comment
 */
public class UserDetailRetrievalRequest extends APIRequest {
  private String _userId;

  public UserDetailRetrievalRequest() {
  }

  public String getUserId() {
    return _userId;
  }

  public void setUserId(String userId) {
    _userId = userId;
  }
}
