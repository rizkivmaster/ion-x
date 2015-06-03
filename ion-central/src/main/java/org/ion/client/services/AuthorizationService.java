package org.ion.client.services;

import org.ion.client.domain.user.Account;
import org.ion.client.domain.user.User;
import org.ion.client.services.util.UserSession;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public interface AuthorizationService {
  /*
   * Quite like userLogin and logout mechanism
   */
  boolean hasLoginAuthority(User user, String password) throws Exception;
}
