package org.ion.client.services.implementation;

import org.ion.client.domain.user.User;
import org.ion.client.repository.UserDataRepository;
import org.ion.client.services.EntityIdGeneratorService;
import org.ion.client.services.UserDataService;
import org.ion.client.services.util.UserCreationSpec;
import org.ion.client.services.util.UserDeletionSpec;
import org.ion.client.services.util.UserSession;

/**
 * Created by rizkivmaster on 4/24/15.
 */
public class UserDataServiceImpl implements UserDataService {
  private UserDataRepository _userDataRepository;
  private EntityIdGeneratorService _entityIdGeneratorService;

  public UserDataServiceImpl(
      UserDataRepository userDataRepository,
      EntityIdGeneratorService entityIdGeneratorService
      )
  {
    _userDataRepository = userDataRepository;
    _entityIdGeneratorService = entityIdGeneratorService;
  }


  @Override
  public void createNewUser(UserCreationSpec userCreationSpec) throws Exception{
    assert userCreationSpec!=null;

    User newUser = new User();
    String newUserId = _entityIdGeneratorService.generateNewID();
    newUser.setId(newUserId);
    newUser.setEmail(userCreationSpec.getEmail());
    newUser.setFirstname(userCreationSpec.getFirstName());
    newUser.setLastname(userCreationSpec.getLastName());
    newUser.setGender(userCreationSpec.getGender());
    _userDataRepository.upsertUser(newUser);
  }

  @Override
  public void deleteUser(UserDeletionSpec userDeletionSpec) {
    // TODO impl
  }

  @Override
  public UserSession getUserByUsername(String username) throws Exception {
    assert username!=null;
    return _userDataRepository.getUserByUsername(username);
  }

  @Override
  public User getUserById(String userId) throws Exception {
    assert userId!=null;

    return _userDataRepository.getUserById(userId);
  }
}
