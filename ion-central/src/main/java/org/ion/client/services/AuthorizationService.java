package org.ion.client.services;

import org.ion.client.services.util.LegalAccessCreationResult;
import org.ion.client.services.util.LegalAccessCreationSpec;
import org.ion.client.services.util.LegalAccessDeletionResult;
import org.ion.client.services.util.LegalAccessDeletionSpec;
import org.ion.client.services.util.LegalAccessUpdateResult;
import org.ion.client.services.util.LegalAccessUpdateSpec;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public interface AuthorizationService {
  /*
   * Quite like login and logout mechanism
   */
  LegalAccessCreationResult createLegalAccess(LegalAccessCreationSpec legalAccessCreationSpec);
  LegalAccessUpdateResult updateLegalAccess(LegalAccessUpdateSpec legalAccessUpdateSpec);
  LegalAccessDeletionResult deleteLegalAccess(LegalAccessDeletionSpec legalAccessDeletionSpec);
}
