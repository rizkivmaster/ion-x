package org.ion.client.services.implementation;

import org.ion.client.accessors.AccountDataAccessor;
import org.ion.client.services.UserDataService;
import org.ion.client.services.util.CustomerReadDetailResult;
import org.ion.client.services.util.CustomerReadDetailSpec;
import org.ion.client.services.util.UserRegistrationConfirmationResult;
import org.ion.client.services.util.UserRegistrationConfirmationSpec;
import org.ion.client.services.util.UserRegistrationCreationResult;
import org.ion.client.services.util.UserRegistrationCreationSpec;
import org.ion.client.services.util.UserRegistrationDeletionResult;
import org.ion.client.services.util.UserRegistrationDeletionSpec;

/**
 * Created by rizkivmaster on 4/24/15.
 */
public class UserDataServiceImpl implements UserDataService {
  private final AccountDataAccessor _customerDataAccessor;

  public UserDataServiceImpl(AccountDataAccessor customerDataAccessor) {
    _customerDataAccessor = customerDataAccessor;
  }

 //TODO implement password hashing
  @Override
  public UserRegistrationCreationResult createUserRegistration(UserRegistrationCreationSpec userRegistrationCreationSpec) {
//    _customerDataAccessor.insertNewCustomer(
//        registrationCreationSpec.getUsername(),
//        registrationCreationSpec.getPassword(),
//        registrationCreationSpec.getFirstName(),
//        registrationCreationSpec.getLastName(),
//        registrationCreationSpec.getEmail(),
//        true,
//        registrationCreationSpec.getGender() == SexType.MALE ? "male" : "female",
//        registrationCreationSpec.getPhoneNumber(),
//        new DateTime(),
//        0L,
//        registrationCreationSpec.getAddress()
//    );
    return null;
  }

  @Override
  public UserRegistrationDeletionResult deleteUserRegistration(UserRegistrationDeletionSpec userRegistrationDeletionSpec) {

    return null;
  }

  @Override
  public UserRegistrationConfirmationResult confirmUserRegistration(UserRegistrationConfirmationSpec userRegistrationConfirmationSpec) {
    return null;
  }

  @Override
  public CustomerReadDetailResult readCustomerDetail(CustomerReadDetailSpec customerReadDetailSpec) {
//    Customer customer = _customerDataAccessor.readCustomerByUsername(customerReadDetailSpec.getUsername());
//    return new CustomerReadDetailResult(customer);
    return null;
  }
}
