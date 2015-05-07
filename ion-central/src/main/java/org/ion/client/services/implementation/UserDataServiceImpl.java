package org.ion.client.services.implementation;

import org.ion.client.accessors.CustomerDataAccessorImpl;
import org.ion.client.domain.enumeration.SexType;
import org.ion.client.domain.user.Customer;
import org.ion.client.services.UserDataService;
import org.ion.client.services.util.CustomerReadDetailResult;
import org.ion.client.services.util.CustomerReadDetailSpec;
import org.ion.client.services.util.RegistrationConfirmationResult;
import org.ion.client.services.util.RegistrationConfirmationSpec;
import org.ion.client.services.util.RegistrationCreationResult;
import org.ion.client.services.util.RegistrationCreationSpec;
import org.ion.client.services.util.RegistrationDeletionResult;
import org.ion.client.services.util.RegistrationDeletionSpec;
import org.joda.time.DateTime;

/**
 * Created by rizkivmaster on 4/24/15.
 */
public class UserDataServiceImpl implements UserDataService {
  private final CustomerDataAccessorImpl _customerDataAccessorImpl;

  public UserDataServiceImpl(CustomerDataAccessorImpl customerDataAccessorImpl) {
    _customerDataAccessorImpl = customerDataAccessorImpl;
  }

 //TODO implement password hashing
  @Override
  public RegistrationCreationResult createRegistration(RegistrationCreationSpec registrationCreationSpec) {
    _customerDataAccessorImpl.insertNewCustomer(
        registrationCreationSpec.getUsername(),
        registrationCreationSpec.getPassword(),
        registrationCreationSpec.getFirstName(),
        registrationCreationSpec.getLastName(),
        registrationCreationSpec.getEmail(),
        true,
        registrationCreationSpec.getGender()==SexType.MALE?"male":"female",
        registrationCreationSpec.getPhoneNumber(),
        new DateTime(),
        0L,
        registrationCreationSpec.getAddress()
    );
    return null;
  }

  @Override
  public RegistrationDeletionResult deleteRegistration(RegistrationDeletionSpec registrationDeletionSpec) {

    return null;
  }

  @Override
  public RegistrationConfirmationResult confirmRegistration(RegistrationConfirmationSpec registrationConfirmationSpec) {
    return null;
  }

  @Override
  public CustomerReadDetailResult readCustomerDetail(CustomerReadDetailSpec customerReadDetailSpec) {
    Customer customer = _customerDataAccessorImpl.readCustomerByUsername(customerReadDetailSpec.getUsername());
    return new CustomerReadDetailResult(customer);
  }
}
