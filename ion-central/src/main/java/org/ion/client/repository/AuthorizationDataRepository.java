package org.ion.client.repository;

import org.ion.client.domain.user.Account;
import org.ion.client.domain.security.Authority;
import org.ion.client.domain.security.AuthorityPass;

/**
 * // TODO Comment
 */
public interface AuthorizationDataRepository {

  void upsertAuthority(Authority authority);

  void upsertAuthorityWithPass(Authority authority, AuthorityPass authorityPass);

  Authority getAuthority(Account account);

  AuthorityPass getAuthorityPass(Authority authority);
}
