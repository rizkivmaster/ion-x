package org.ion.client.repository;

import org.ion.client.domain.user.Account;
import org.ion.client.domain.user.User;
import org.ion.client.services.util.UserSession;

/**
 * // TODO Comment
 */
public interface UserDataRepository {
  void upsertCustomer(Account account);
  Account getCustomer(String id);
  Account getCustomerWithEmail(String email);
  Account getCustomerWithUsername(String username);

  void upsertUser(User user) throws Exception;
  UserSession getUserByUsername(String username) throws Exception;
  User getUserById(String id) throws Exception;

}
