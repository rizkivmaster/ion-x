package org.ion.client.services;

import org.ion.client.IONComponent;
import org.ion.client.repository.UserDataRepository;
import org.springframework.boot.test.IntegrationTest;

import java.util.Random;

/**
 * Created by rizkivmaster on 4/25/15.
 * silakan dieksten
 */
@IntegrationTest
public abstract class IONIntegrationTestBase {
  private final IONComponent _ionComponent;


  public IONIntegrationTestBase() {
    _ionComponent = new IONComponent();
  }

  public UserDataRepository getUserDataService(){
    return _ionComponent.getUserDataService();
  }
//  public TransactionService getTransactionService(){ return _ionComponent.getTransactionService();}
  /*
   * utilities
   */

  private final Random random = new Random();

  protected int createPositiveRandomInt(){
    return random.nextInt(10000);
  }
}
