package org.ion.client.domain.user;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class FundingGroup {
  private final String _id;
  private final String _name;
  private final String _description;
  private final long _balance;

  public FundingGroup(String id, String name, String description, long balance) {
    _id = id;
    _name = name;
    _description = description;
    _balance = balance;
  }
}
