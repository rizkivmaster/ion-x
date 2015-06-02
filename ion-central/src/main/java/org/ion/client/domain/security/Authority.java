package org.ion.client.domain.security;

import org.ion.client.domain.enumeration.AuthorityType;
import java.util.UUID;

/**
 * // TODO Comment
 */
public abstract class Authority {
  private String _id;
  private String _userId;
  private boolean _hasright;
  private boolean _haspasskey;

  public Authority() {
  }

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  public String getUserId() {
    return _userId;
  }

  public void setUserId(String userId) {
    _userId = userId;
  }

  public boolean isHasright() {
    return _hasright;
  }

  public void setHasright(boolean hasright) {
    _hasright = hasright;
  }

  public boolean isHaspasskey() {
    return _haspasskey;
  }

  public void setHaspasskey(boolean haspasskey) {
    _haspasskey = haspasskey;
  }
}
