package org.ion.client.services;

import org.ion.client.domain.user.Account;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public interface AuthorizationService {
  /*
   * Quite like userLogin and logout mechanism
   */
  //TODO create result
  void createLoginAuthority(Account account, String requestedPassword);
  boolean isValidToLogin(Account account, String password);
  boolean hasLoginAuthority(User user, String password);
//  void deleteLegalAccess(LegalAccessDeletionSpec legalAccessDeletionSpec);
//  void updateLegalAccess(LegalAccessUpdateSpec legalAccessUpdateSpec);
}
