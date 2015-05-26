package org.ion.client.services;

/**
 * // TODO Comment
 */
public class ServiceSpec<T> {
  private T _data;
  public ServiceSpec() {
  }

  public ServiceSpec(T data) {
    _data = data;
  }


  public T getData() {
    return _data;
  }

  public void setData(T data) {
    _data = data;
  }
}
