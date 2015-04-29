package org.ion.client.services;

import org.ion.client.IONComponent;
import org.springframework.boot.test.IntegrationTest;

/**
 * Created by rizkivmaster on 4/25/15.
 * silakan dieksten
 */
@IntegrationTest
public class IONIntegrationTestBase {
  private final IONComponent _ionComponent;


  public IONIntegrationTestBase(IONComponent ionComponent) {
    _ionComponent = ionComponent;
  }

  public UserDataService getUserDataService(){
    return _ionComponent.getUserDataService();
  }
}
