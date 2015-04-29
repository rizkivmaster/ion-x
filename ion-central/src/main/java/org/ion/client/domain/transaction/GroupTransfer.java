package org.ion.client.domain.transaction;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class GroupTransfer extends HorizontalTransaction {
  private final String _groupId;


  public GroupTransfer(String id, long amount, String name, String description, boolean hasArrived, String groupId) {
    super(id, amount, name, description, hasArrived);
    _groupId = groupId;
  }
}
