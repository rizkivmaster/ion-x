package org.ion.client;

import org.ion.client.accessors.CustomerDataAccessor;
import org.ion.client.controller.IONMobileController;
import org.ion.client.services.IONIntegrationTestBase;
import org.ion.client.services.TransactionService;
import org.ion.client.services.TransactionServiceImpl;
import org.ion.client.services.UserDataService;
import org.ion.client.services.UserDataServiceImpl;
import org.ion.util.Startable;

/**
 * Created by rizkivmaster on 4/25/15.
 */
public class IONComponent implements Startable{
  /*
   * Contains all Data Access Object
   */
  private final CustomerDataAccessor _customerDataAccessor;


  /* Contains all services
   *
   */

  private final UserDataService _userDataService;
  private final TransactionService _transactionService;

  /**
   *  the next part is the controller section
   */

  private final IONMobileController _mobileController;


  public IONComponent() {
    _customerDataAccessor = new CustomerDataAccessor();

    _userDataService = new UserDataServiceImpl(_customerDataAccessor);
    _transactionService = new TransactionServiceImpl(_customerDataAccessor);

    _mobileController = new IONMobileController(_userDataService);
  }

  @Override
  public void start() {

  }

  @Override
  public void shutdown() {

  }

  public UserDataService getUserDataService() {
    return _userDataService;
  }

  public TransactionService getTransactionService() {
    return _transactionService;
  }
}
