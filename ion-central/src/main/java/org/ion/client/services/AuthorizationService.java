package org.ion.client.services;

import org.ion.client.services.util.LegalAccessDeletionResult;
import org.ion.client.services.util.LegalAccessDeletionSpec;
import org.ion.client.services.util.LegalAccessUpdateResult;
import org.ion.client.services.util.LegalAccessUpdateSpec;
import org.ion.client.services.util.LoginCreationSpec;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public interface AuthorizationService {
  /*
   * Quite like login and logout mechanism
   */
  //TODO create result
  void createLoginAuthority(LoginCreationSpec authorityCreationSpec);
  boolean hasLoginAuthority(String userId);
//  void deleteLegalAccess(LegalAccessDeletionSpec legalAccessDeletionSpec);
//  void updateLegalAccess(LegalAccessUpdateSpec legalAccessUpdateSpec);
}
