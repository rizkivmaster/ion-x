package org.ion.client.domain.user;
import java.util.UUID;

/**
 * // TODO Comment
 */
public class AuthorityPass {
  private String _id;
  private String _authorityId;
  private String _passKey;

  protected AuthorityPass(String id, String authorityId, String passKey) {
    _id = id;
    _authorityId = authorityId;
    _passKey = passKey;
  }

  public static AuthorityPass createPassFromAuthority(Authority authority, String passKey){
    assert authority!=null;
    assert passKey!=null && !"".equals(passKey);
    return new AuthorityPass(UUID.randomUUID().toString(),authority.getId(),passKey);
  }

  public String getId() {
    return _id;
  }

  public String getAuthorityId() {
    return _authorityId;
  }

  public String getPassKey() {
    return _passKey;
  }
}
