package org.ionexchange.v1.objects;

import org.ionexchange.v1.APIResponseStatus;

/**
 * // TODO Comment
 */
public abstract class APIResponse {
  private APIResponseStatus _apiResponseStatus;
  private String _reason;

  public APIResponseStatus getApiResponseStatus() {
    return _apiResponseStatus;
  }

  public void setApiResponseStatus(APIResponseStatus apiResponseStatus) {
    _apiResponseStatus = apiResponseStatus;
  }

  public String getReason() {
    return _reason;
  }

  public void setReason(String reason) {
    _reason = reason;
  }
}
