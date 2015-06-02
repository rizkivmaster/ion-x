package org.ion.client.domain.security;

/**
 * it depends on the use cases, please check the documents again
 */

public interface Authorizable {
  boolean canPerformP2PTransfer();
  boolean canLogin();
  boolean canChangeIdentity();
}
