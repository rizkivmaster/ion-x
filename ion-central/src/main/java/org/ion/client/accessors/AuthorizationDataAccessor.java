package org.ion.client.accessors;

import org.ion.client.accessors.util.AccountAuthorization;

/**
 * // TODO Comment
 */
public interface AuthorizationDataAccessor {
  void upsertCustomerAuthorization();
  AccountAuthorization getAuthorizationData(String userId);
}
