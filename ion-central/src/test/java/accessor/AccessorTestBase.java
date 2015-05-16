package accessor;

import org.ion.client.accessors.implementation.AccountDataAccessorImpl;
import org.ion.client.services.IONIntegrationTestBase;

/**
 * // TODO Comment
 */
public abstract class AccessorTestBase extends IONIntegrationTestBase {

  /*
     * Accessors lists
     */
  private final AccountDataAccessorImpl _customerDataAccessorImpl;

  public AccountDataAccessorImpl getCustomerDataAccessorImpl() {
    return _customerDataAccessorImpl;
  }


  protected AccessorTestBase() {
    _customerDataAccessorImpl = new AccountDataAccessorImpl();
  }


}
