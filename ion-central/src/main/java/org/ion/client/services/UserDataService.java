package org.ion.client.services;

import org.ion.client.domain.user.User;
import org.ion.client.services.util.UserCreationSpec;
import org.ion.client.services.util.UserDeletionSpec;
import org.ion.client.services.util.UserSession;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public interface UserDataService {


  void createNewUser(UserCreationSpec userCreationSpec) throws Exception;
  void deleteUser(UserDeletionSpec userDeletionSpec) throws Exception;
  UserSession getUserByUsername(String username) throws Exception;
  User getUserById(String userId) throws Exception;


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
//  public CustomerReadDetailResult readCustomerDetail(CustomerReadDetailSpec customerReadDetailSpec);
}
