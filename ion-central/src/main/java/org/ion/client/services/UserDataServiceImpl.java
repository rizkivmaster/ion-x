package org.ion.client.services;

import org.ion.client.accessors.CustomerDataAccessor;
import org.ion.client.domain.enumeration.SexType;
import org.ion.client.domain.user.Customer;
import org.ion.client.services.util.CustomerReadDetailResult;
import org.ion.client.services.util.CustomerReadDetailSpec;
import org.ion.client.services.util.RegistrationConfirmationResult;
import org.ion.client.services.util.RegistrationConfirmationSpec;
import org.ion.client.services.util.RegistrationCreationResult;
import org.ion.client.services.util.RegistrationCreationSpec;
import org.ion.client.services.util.RegistrationDeletionResult;
import org.ion.client.services.util.RegistrationDeletionSpec;

import java.sql.Date;

/**
 * Created by rizkivmaster on 4/24/15.
 */
public class UserDataServiceImpl implements UserDataService{
  private final CustomerDataAccessor _customerDataAccessor;

  public UserDataServiceImpl(CustomerDataAccessor customerDataAccessor) {
    _customerDataAccessor = customerDataAccessor;
  }


  @Override
  public RegistrationCreationResult createRegistration(RegistrationCreationSpec registrationCreationSpec) {
    _customerDataAccessor.insertNewCustomer(
        registrationCreationSpec.getUsername(),
        "2tf13432",
        registrationCreationSpec.getFirstName(),
        registrationCreationSpec.getLastName(),
        registrationCreationSpec.getEmail(),
        true,
        registrationCreationSpec.getGender()==SexType.MALE?"male":"female",
        registrationCreationSpec.getPhoneNumber(),
        new Date(2015,4,25),
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
    Customer customer = _customerDataAccessor.readCustomerByUsername(customerReadDetailSpec.getUsername());
    return new CustomerReadDetailResult(customer);
  }
}
