package accessor;

import org.ion.client.accessors.CustomerDataAccessor;
import org.ion.client.services.IONIntegrationTestBase;

import java.util.Random;

/**
 * // TODO Comment
 */
public abstract class AccessorTestBase extends IONIntegrationTestBase {

  /*
     * Accessors lists
     */
  private final CustomerDataAccessor _customerDataAccessor;

  public CustomerDataAccessor getCustomerDataAccessor() {
    return _customerDataAccessor;
  }


  protected AccessorTestBase() {
    _customerDataAccessor = new CustomerDataAccessor();
  }


}
