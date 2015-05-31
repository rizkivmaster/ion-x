package org.ion.client.services;

/**
 * // TODO Comment
 */
public class P2PTopupSessionData {
  private String _token;
  private TopupSessionStatus _topupSessionStatus;

  public P2PTopupSessionData() {
  }

  public String getToken() {
    return _token;
  }

  public void setToken(String token) {
    _token = token;
  }

  public TopupSessionStatus getTopupSessionStatus() {
    return _topupSessionStatus;
  }

  public void setTopupSessionStatus(TopupSessionStatus topupSessionStatus) {
    _topupSessionStatus = topupSessionStatus;
  }
}
