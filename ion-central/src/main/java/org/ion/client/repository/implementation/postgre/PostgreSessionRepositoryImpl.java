package org.ion.client.repository.implementation.postgre;

import org.ion.client.repository.SessionRepository;

/**
 * // TODO Comment
 */
public class PostgreSessionRepositoryImpl extends PostgreRepositoryBase implements SessionRepository {
  @Override
  public Object get(String key) {
    return null;  // TODO impl
  }

  @Override
  public void set(String key, int ttl, Object o) {
    // TODO impl
  }

  @Override
  public void delete(String key) {
    // TODO impl
  }
}
