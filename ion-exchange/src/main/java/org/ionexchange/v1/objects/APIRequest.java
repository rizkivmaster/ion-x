package org.ionexchange.v1.objects;

import org.ionexchange.v1.APIRequestStatus;

/**
 * // TODO Comment
 */
public abstract class APIRequest {
  private APIRequestStatus _apiRequestStatus;

  public APIRequestStatus getApiRequestStatus() {
    return _apiRequestStatus;
  }

  public void setApiRequestStatus(APIRequestStatus apiRequestStatus) {
    _apiRequestStatus = apiRequestStatus;
  }
}
