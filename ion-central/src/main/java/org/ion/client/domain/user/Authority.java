package org.ion.client.domain.user;

import org.ion.client.domain.enumeration.AuthorityType;
import java.util.UUID;

/**
 * // TODO Comment
 */
public class Authority {
  private String _id;
  private AuthorityType _authorityType;
  private String _userId;
  private boolean _hasright;
  private boolean _haspasskey;

  protected Authority(String id, AuthorityType authorityType, String userId, boolean hasright, boolean haspasskey) {
    _id = id;
    _authorityType = authorityType;
    _userId = userId;
    _hasright = hasright;
    _haspasskey = haspasskey;
  }

  //factory
  public static Authority createLoginAuthority(Account account){
    return new Authority(UUID.randomUUID().toString(),AuthorityType.LOGIN,account.getId(),true,true);
  }

  public String getId() {
    return _id;
  }

  public AuthorityType getAuthorityType() {
    return _authorityType;
  }

  public String getUserId() {
    return _userId;
  }

  public boolean isHasright() {
    return _hasright;
  }

  public boolean isHaspasskey() {
    return _haspasskey;
  }
}
