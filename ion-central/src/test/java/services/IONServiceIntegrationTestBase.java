package services;


import org.ion.client.services.IONIntegrationTestBase;
import org.ion.client.services.TransactionService;
import org.ion.client.services.UserDataService;

import java.util.Random;

/**
 * // TODO Comment
 */
/*public abstract class IONServiceIntegrationTestBase extends IONIntegrationTestBase {
                    *//*
   * utilities
   *//*

  private final Random random = new Random();


  protected int createPositiveRandomInt(){
    return random.nextInt(10000);
  }


  *//*
   * services
   *//*

  private final TransactionService _transactionService;
  private final UserDataService _userDataService;

  protected IONServiceIntegrationTestBase() {
    _transactionService = getTransactionService();
    _userDataService = getUserDataService();
  }

}*/
