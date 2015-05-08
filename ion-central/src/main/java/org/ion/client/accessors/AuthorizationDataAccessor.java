package org.ion.client.accessors;

import org.ion.client.domain.user.Account;
import org.ion.client.domain.user.Authority;
import org.ion.client.domain.user.AuthorityPass;

/**
 * // TODO Comment
 */
public interface AuthorizationDataAccessor {
  void upsertAuthority(Authority authority);
  void upsertAuthorityWithPass(Authority authority, AuthorityPass authorityPass);
  Authority getAuthority(Account account);
  AuthorityPass getAuthorityPass(Authority authority);
}
