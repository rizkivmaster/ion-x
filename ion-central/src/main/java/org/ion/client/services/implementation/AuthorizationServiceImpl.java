package org.ion.client.services.implementation;

import org.ion.client.domain.user.User;
import org.ion.client.services.AuthorizationService;

/**
 * // TODO Comment
 */
public class AuthorizationServiceImpl implements AuthorizationService {
  @Override
  public boolean hasLoginAuthority(User user, String password) throws Exception {
    return false;  // TODO impl
  }
}
