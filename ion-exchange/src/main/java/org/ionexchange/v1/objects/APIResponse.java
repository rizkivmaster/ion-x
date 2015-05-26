package org.ionexchange.v1.objects;

import org.ionexchange.v1.APIResponseStatus;

/**
 * // TODO Comment
 */
public class APIResponse<T> {
  private APIResponseStatus _apiResponseStatus;
  private String _failedReason;
  private T _data;

  public APIResponse() {
  }

  public APIResponseStatus getApiResponseStatus() {
    return _apiResponseStatus;
  }

  public void setApiResponseStatus(APIResponseStatus apiResponseStatus) {
    _apiResponseStatus = apiResponseStatus;
  }

  public String getFailedReason() {
    return _failedReason;
  }

  public void setFailedReason(String failedReason) {
    _failedReason = failedReason;
  }

  public T getData() {
    return _data;
  }

  public void setData(T data) {
    _data = data;
  }
}
