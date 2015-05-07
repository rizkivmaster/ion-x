package org.ion.client.accessors.util;

import org.ion.client.domain.user.Authorizable;

/**
 * // TODO Comment
 */
public class AccountAuthorization implements Authorizable {
  @Override
  public boolean canPerformP2PTransfer() {
    return false;  // TODO impl
  }

  @Override
  public boolean canLogin() {
    return false;  // TODO impl
  }

  @Override
  public boolean canChangeIdentity() {
    return false;  // TODO impl
  }
}
