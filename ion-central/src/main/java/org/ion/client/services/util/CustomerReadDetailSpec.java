package org.ion.client.services.util;

/**
 * Created by rizkivmaster on 4/25/15.
 */
public class CustomerReadDetailSpec {
  private final String username;

  public CustomerReadDetailSpec(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }
}
