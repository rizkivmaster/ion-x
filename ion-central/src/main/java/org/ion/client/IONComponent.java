package org.ion.client;

import org.ion.client.accessors.AccountDataAccessor;
import org.ion.client.accessors.AccountSavingAccessor;
import org.ion.client.accessors.implementation.AccountDataAccessorMockImpl;
import org.ion.client.accessors.implementation.AccountSavingAccessorImpl;
import org.ion.client.accessors.AuthorizationDataAccessor;
import org.ion.client.accessors.implementation.AuthorizationDataAccessorImpl;
import org.ion.client.api.v1.UserAPI;
import org.ion.client.api.v1.UserAPIImpl;
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
  private final AccountDataAccessor _customerDataAccessorImpl;
  private final AuthorizationDataAccessor _authorizationDataAccessor;
  private final AccountSavingAccessor _accountSavingAccessor;



  /* Contains all services
   *
   */

  private final UserDataService _userDataService;
//  private final TransactionService _transactionService;

  /**
   *  the next part is the controller section
   */

//  private final IONMobileController _mobileController;
  private final UserAPI _userAPI;


  public IONComponent() {
    _customerDataAccessorImpl = new AccountDataAccessorMockImpl();
    _authorizationDataAccessor = new AuthorizationDataAccessorImpl();
    _accountSavingAccessor = new AccountSavingAccessorImpl();



    _userDataService = new UserDataServiceImpl(_customerDataAccessorImpl);
//    _transactionService = new TransactionServiceImpl(accou)

//    _mobileController = new IONMobileController(_userDataService);
    _userAPI = new UserAPIImpl(_userDataService);
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

//  public TransactionService getTransactionService() {
//    return _transactionService;
//  }
}
