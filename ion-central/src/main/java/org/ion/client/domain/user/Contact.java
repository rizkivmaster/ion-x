package org.ion.client.domain.user;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class Contact {
  private final String _id;
  private final String _fromAccountId;
  private final String _fromAccountUsername;
  private final String _toAccountId;
  private final String _toAccountUsername;

  public Contact(String id, String fromAccountId, String fromAccountUsername, String toAccountId, String toAccountUsername) {
    _id = id;
    _fromAccountId = fromAccountId;
    _fromAccountUsername = fromAccountUsername;
    _toAccountId = toAccountId;
    _toAccountUsername = toAccountUsername;
  }
}
