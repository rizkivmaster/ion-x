package org.ion.client.domain.security;

import java.util.UUID;

/**
 * // TODO Comment
 */
public class AuthorityPass {
  private String _id;
  private String _authorityId;


  public AuthorityPass() {
  }

  public String getId() {
    return _id;
  }

  public void setId(String id) {
    _id = id;
  }

  public String getAuthorityId() {
    return _authorityId;
  }

  public void setAuthorityId(String authorityId) {
    _authorityId = authorityId;
  }
}
