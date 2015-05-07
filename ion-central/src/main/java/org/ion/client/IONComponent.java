package org.ion.client;

import org.ion.client.accessors.CustomerDataAccessorImpl;
import org.ion.client.controller.IONMobileController;
import org.ion.client.services.TransactionService;
import org.ion.client.services.implementation.TransactionServiceImpl;
import org.ion.client.services.UserDataService;
import org.ion.client.services.implementation.UserDataServiceImpl;
import org.ion.util.Startable;

/**
 * Created by rizkivmaster on 4/25/15.
 */
public class IONComponent implements Startable{
  /*
   * Contains all Data Access Object
   */
  private final CustomerDataAccessorImpl _customerDataAccessorImpl;


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
    _customerDataAccessorImpl = new CustomerDataAccessorImpl();

    _userDataService = new UserDataServiceImpl(_customerDataAccessorImpl);
    _transactionService = new TransactionServiceImpl(_customerDataAccessorImpl);

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
