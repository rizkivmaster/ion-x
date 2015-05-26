package org.ionexchange.v1.objects;

import org.ionexchange.v1.APIRequestStatus;

/**
 * // TODO Comment
 */
public class APIRequest<T> {
  private APIRequestStatus _apiRequestStatus;
  private T _data;

  public APIRequest() {
  }


  public APIRequestStatus getApiRequestStatus() {
    return _apiRequestStatus;
  }

  public void setApiRequestStatus(APIRequestStatus apiRequestStatus) {
    _apiRequestStatus = apiRequestStatus;
  }

  public T getData() {
    return _data;
  }

  public void setData(T data) {
    _data = data;
  }
}
