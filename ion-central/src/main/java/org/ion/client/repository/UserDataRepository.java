package org.ion.client.repository;

import org.ion.client.domain.user.Account;
import org.ion.client.domain.user.User;
import org.ion.client.services.util.UserSession;

/**
 * // TODO Comment
 */
public interface UserDataRepository {

  void upsertUser(User user) throws Exception;

  User getUserByUsername(String username) throws Exception;

  User getUserById(String id) throws Exception;

}
