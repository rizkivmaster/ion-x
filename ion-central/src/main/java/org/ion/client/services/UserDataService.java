package org.ion.client.services;

import org.ion.client.services.util.CustomerReadDetailResult;
import org.ion.client.services.util.CustomerReadDetailSpec;
import org.ion.client.services.util.RegistrationConfirmationResult;
import org.ion.client.services.util.RegistrationConfirmationSpec;
import org.ion.client.services.util.RegistrationCreationResult;
import org.ion.client.services.util.RegistrationCreationSpec;
import org.ion.client.services.util.RegistrationDeletionResult;
import org.ion.client.services.util.RegistrationDeletionSpec;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public interface UserDataService {


  public RegistrationCreationResult createRegistration(RegistrationCreationSpec registrationCreationSpec);
  public RegistrationDeletionResult deleteRegistration(RegistrationDeletionSpec registrationDeletionSpec);
  public RegistrationConfirmationResult confirmRegistration(RegistrationConfirmationSpec registrationConfirmationSpec);

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
