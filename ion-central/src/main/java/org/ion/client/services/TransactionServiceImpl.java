package org.ion.client.services;

import org.ion.client.accessors.CustomerDataAccessor;
import org.ion.client.domain.user.Customer;
import org.ion.client.services.util.TopUpCancellationResult;
import org.ion.client.services.util.TopUpCancellationSpec;
import org.ion.client.services.util.TopUpConfirmationResult;
import org.ion.client.services.util.TopUpConfirmationSpec;
import org.ion.client.services.util.TopUpTokenCreationResult;
import org.ion.client.services.util.TopUpTokenCreationSpec;

/**
 * // TODO Comment
 */
public class TransactionServiceImpl implements TransactionService {
  private final CustomerDataAccessor _customerDataAccessor;

  public TransactionServiceImpl(CustomerDataAccessor customerDataAccessor) {
    _customerDataAccessor = customerDataAccessor;
  }


  //TODO this is a direct topup
  @Override
  public void createTopUpToken(String username, long amount) throws Exception {
    assert amount>0;
    Customer customer = _customerDataAccessor.readCustomerByUsername(username);
    _customerDataAccessor.setCustomerBalance(username, customer.getBalance()+amount);
  }

  @Override
  public void p2pTransfer(String srcUsername, String dstUsername, long amount) throws Exception {
    assert amount>0;
    Customer srcCustomer = _customerDataAccessor.readCustomerByUsername(srcUsername);
    assert srcCustomer.getBalance()-amount>0;
    Customer dstCustomer = _customerDataAccessor.readCustomerByUsername(dstUsername);
    _customerDataAccessor.setCustomerBalance(dstCustomer.getUsername(),dstCustomer.getBalance()+amount);
  }

}
