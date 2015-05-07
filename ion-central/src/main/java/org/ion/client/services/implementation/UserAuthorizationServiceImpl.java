package org.ion.client.services.implementation;

import org.ion.client.accessors.AuthorizationDataAccessor;
import org.ion.client.domain.user.Authorizable;
import org.ion.client.services.AuthorizationService;
import org.ion.client.services.util.LoginCreationSpec;

/**
 * // TODO Comment
 */
public class UserAuthorizationServiceImpl implements AuthorizationService {
  private AuthorizationDataAccessor _authorizationDataAccessor;

  public UserAuthorizationServiceImpl(AuthorizationDataAccessor authorizationDataAccessor) {
    _authorizationDataAccessor = authorizationDataAccessor;
  }

  @Override
  public void createLoginAuthority(LoginCreationSpec authorityCreationSpec) {
    // TODO impl
  }

  @Override
  public boolean hasLoginAuthority(String userId) {
    Authorizable authority = _authorizationDataAccessor.getAuthorizationData(userId);
    return authority.canLogin();
  }
}
