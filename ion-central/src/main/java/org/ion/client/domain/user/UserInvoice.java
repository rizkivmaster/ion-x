package org.ion.client.domain.user;

/**
 * Created by rizkivmaster on 4/23/15.
 */
public class UserInvoice {
  private final String _id;
  private final String _issuerId;//should be the merchant who issued this invoice
  private final String _issuedId;//should be the customer who the merchant issued
  private final String _subject;
  private final String _description;
  private final long _balance;
  private final boolean _hasBeenPaid;

  public UserInvoice(String id, String issuerId, String issuedId, String subject, String description, long balance, boolean hasBeenPaid) {
    _id = id;
    _issuerId = issuerId;
    _issuedId = issuedId;
    _subject = subject;
    _description = description;
    _balance = balance;
    _hasBeenPaid = hasBeenPaid;
  }
}
