package org.ion.client.repository;

/**
 * // TODO Comment
 */
public interface SessionRepository {
  Object get(String key);
  void set(String key, int ttl, Object o);
  void delete(String key);
}