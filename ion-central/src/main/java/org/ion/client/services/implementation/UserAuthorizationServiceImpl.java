package org.ion.client.services.implementation;

import org.ion.client.accessors.AuthorizationDataAccessor;
import org.ion.client.domain.user.Account;
import org.ion.client.domain.user.Authority;
import org.ion.client.domain.user.AuthorityPass;
import org.ion.client.domain.user.Authorizable;
import org.ion.client.services.AuthorizationService;
import org.ion.client.services.util.LoginCreationSpec;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * // TODO Comment
 */
public class UserAuthorizationServiceImpl implements AuthorizationService {
  private AuthorizationDataAccessor _authorizationDataAccessor;

  public UserAuthorizationServiceImpl(AuthorizationDataAccessor authorizationDataAccessor) {
    _authorizationDataAccessor = authorizationDataAccessor;
  }
  @Override
  public void createLoginAuthority(Account account, String requestedPassword) {
    Authority authority =  Authority.createLoginAuthority(account);
    try{
      String hashedKey = getHashedKey(requestedPassword);
      AuthorityPass authorityPass = AuthorityPass.createPassFromAuthority(authority,hashedKey);
      _authorizationDataAccessor.upsertAuthorityWithPass(authority,authorityPass);
    }
    catch(Exception e){
     e.printStackTrace();
    }
  }

  @Override
  public boolean isValidToLogin(Account account, String password) {
    try{
      String hashedKey = getHashedKey(password);
      Authority authority = _authorizationDataAccessor.getAuthority(account);
      AuthorityPass pass = _authorizationDataAccessor.getAuthorityPass(authority);
      return hashedKey.equals(pass.getPassKey());
    }
    catch(Exception e){
      e.printStackTrace();
    }
    return false;
  }

  private String getHashedKey(String key) throws Exception{
    MessageDigest digest = MessageDigest.getInstance("MD5");
    byte[] hashedKey = digest.digest(key.getBytes());
    BigInteger number = new BigInteger(hashedKey);
    return number.toString();
  }
}
