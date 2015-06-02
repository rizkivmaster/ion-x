package org.ion.client.services.util;

/**
 * // TODO Comment
 */
public class ServiceResult<T> {
  private ServiceResponseStatus _serviceResponseStatus;
  private String _failureReason;
  private T _data;

  public ServiceResult() {
  }

  public ServiceResponseStatus getServiceResponseStatus() {
    return _serviceResponseStatus;
  }

  public void setServiceResponseStatus(ServiceResponseStatus serviceResponseStatus) {
    _serviceResponseStatus = serviceResponseStatus;
  }

  public String getFailureReason() {
    return _failureReason;
  }

  public void setFailureReason(String failureReason) {
    _failureReason = failureReason;
  }

  public T getData() {
    return _data;
  }

  public void setData(T data) {
    _data = data;
  }
}
