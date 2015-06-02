package org.ion.client.repository.implementation;

import org.ion.client.repository.AuthorizationDataAccessor;
import org.ion.client.domain.user.Account;
import org.ion.client.domain.security.Authority;
import org.ion.client.domain.security.AuthorityPass;

/**
 * // TODO Comment
 */
public class AuthorizationDataAccessorImpl implements AuthorizationDataAccessor {

  @Override
  public void upsertAuthority(Authority authority) {
    // TODO impl
  }

  @Override
  public void upsertAuthorityWithPass(Authority authority, AuthorityPass authorityPass) {
    // TODO impl
  }

  @Override
  public Authority getAuthority(Account account) {
    return null;  // TODO impl
  }

  @Override
  public AuthorityPass getAuthorityPass(Authority authority) {
    return null;  // TODO impl
  }
}
