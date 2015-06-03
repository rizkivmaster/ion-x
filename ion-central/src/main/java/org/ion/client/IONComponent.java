package org.ion.client;

import org.ion.client.repository.UserDataRepository;
import org.ion.client.repository.AccountSavingAccessor;
import org.ion.client.repository.implementation.postgre.PostgreAuthorizationDataRepositoryImpl;
import org.ion.client.repository.implementation.UserDataRepositoryMockImpl;
import org.ion.client.repository.implementation.AccountSavingAccessorImpl;
import org.ion.client.repository.AuthorizationDataRepository;
import org.ion.client.api.v1.UserAPI;
import org.ion.client.api.v1.implementation.UserAPIImpl;
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
  private final UserDataRepository _customerDataAccessorImpl;
  private final AuthorizationDataRepository _authorizationDataRepository;
  private final AccountSavingAccessor _accountSavingAccessor;



  /* Contains all services
   *
   */

  private final UserDataRepository _userDataService;
//  private final TransactionService _transactionService;

  /**
   *  the next part is the controller section
   */

//  private final IONMobileController _mobileController;
  private final UserAPI _userAPI;


  public IONComponent() {
    _customerDataAccessorImpl = new UserDataRepositoryMockImpl();
    _authorizationDataRepository = new PostgreAuthorizationDataRepositoryImpl();
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

  public UserDataRepository getUserDataService() {
    return _userDataService;
  }

//  public TransactionService getTransactionService() {
//    return _transactionService;
//  }
}
