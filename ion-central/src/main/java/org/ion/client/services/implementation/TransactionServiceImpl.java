package org.ion.client.services.implementation;

import org.ion.client.accessors.CustomerDataAccessorImpl;
import org.ion.client.domain.user.Customer;
import org.ion.client.services.TransactionService;

/**
 * // TODO Comment
 */
public class TransactionServiceImpl implements TransactionService {
  private final CustomerDataAccessorImpl _customerDataAccessorImpl;

  public TransactionServiceImpl(CustomerDataAccessorImpl customerDataAccessorImpl) {
    _customerDataAccessorImpl = customerDataAccessorImpl;
  }


  //TODO this is a direct topup
  @Override
  public void createTopUpToken(String username, long amount) throws Exception {
    assert amount>0;
    Customer customer = _customerDataAccessorImpl.readCustomerByUsername(username);
    _customerDataAccessorImpl.setCustomerBalance(username, customer.getBalance()+amount);
  }

  @Override
  public void p2pTransfer(String srcUsername, String dstUsername, long amount) throws Exception {
    assert amount>0;
    Customer srcCustomer = _customerDataAccessorImpl.readCustomerByUsername(srcUsername);
    assert srcCustomer.getBalance()-amount>0;
    Customer dstCustomer = _customerDataAccessorImpl.readCustomerByUsername(dstUsername);
    _customerDataAccessorImpl.setCustomerBalance(dstCustomer.getUsername(),dstCustomer.getBalance()+amount);
  }

}
