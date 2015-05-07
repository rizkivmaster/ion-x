package accessor;

import org.ion.client.accessors.CustomerDataAccessorImpl;
import org.ion.client.services.IONIntegrationTestBase;

/**
 * // TODO Comment
 */
public abstract class AccessorTestBase extends IONIntegrationTestBase {

  /*
     * Accessors lists
     */
  private final CustomerDataAccessorImpl _customerDataAccessorImpl;

  public CustomerDataAccessorImpl getCustomerDataAccessorImpl() {
    return _customerDataAccessorImpl;
  }


  protected AccessorTestBase() {
    _customerDataAccessorImpl = new CustomerDataAccessorImpl();
  }


}
