package org.ion.client.services;

import org.ion.client.services.util.CustomerReadDetailResult;
import org.ion.client.services.util.CustomerReadDetailSpec;
import org.ion.client.services.util.UserRegistrationConfirmationResult;
import org.ion.client.services.util.UserRegistrationConfirmationSpec;
import org.ion.client.services.util.UserRegistrationCreationResult;
import org.ion.client.services.util.UserRegistrationCreationSpec;
import org.ion.client.services.util.UserRegistrationDeletionResult;
import org.ion.client.services.util.UserRegistrationDeletionSpec;
import org.ionexchange.v1.objects.UserDetailRetrievalRequest;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public interface UserDataService {


  UserRegistrationCreationResult createUserRegistration(UserRegistrationCreationSpec userRegistrationCreationSpec);
  UserRegistrationDeletionResult deleteUserRegistration(UserRegistrationDeletionSpec userRegistrationDeletionSpec);
  UserRegistrationConfirmationResult confirmUserRegistration(UserRegistrationConfirmationSpec userRegistrationConfirmationSpec);
  UserLoginConfirmationResult confirmUserLogin(UserLoginConfirmationSpec userLoginConfirmationSpec);
  UserLogoutConfirmationResult confirmUserLogout(UserLogoutConfirmationSpec userLogoutConfirmationSpec);

  UserDetailRetrievalResult getUserDetail(UserDetailRetrievalSpec userDetailRetrievalSpec);
  AddUserContactResult addUserContact(AddUserContactSpec addUserContactSpec);
  UserContactConfirmationResult confirmUserContact(UserContactConfirmationSpec userContactConfirmationSpec);

  /*
  public GroupCreationResult createGroup(GroupCreationSpec groupCreationSpec);
  public GroupDeletionResult deleteGroup(GroupDeletionSpec groupDeletionSpec);
  public GroupUpdateResult updateGroup(GroupUpdateSpec groupUpdateSpec);
  public GroupReadResult readGroupDetail(GroupReadSpec groupReadSpec);
  public GroupsRetrievalResult retrieveGroups(GroupRetrievalSpec groupRetrievalSpec);
  public GroupSearchResult searchGroups(GroupSearchResult groupSearchResult);

  public CustomerConnectionCreationResult createCustomerConnection(CustomerConnectionCreationSpec customerConnectionCreationSpec);
  public CustomerConnectionDeletionResult deleteCustomerConnection(CustomerConnectionDeletionSpec customerConnectionDeletionSpec);
  public CustomerConnectionsRetrievalResult retrieveCustomerConnections(CustomerConnectionsRetrievalSpec customerConnectionsRetrievalSpec);
  public CustomerConnectionReadResult readCustomerConnectionDetail(CustomerConnectionReadSpec customerConnectionReadSpec);

  public CustomerSearchResult searchCustomers(CustomerSearchSpec customerSearchSpec);
  */
  public CustomerReadDetailResult readCustomerDetail(CustomerReadDetailSpec customerReadDetailSpec);
}
