package org.ion.client.domain.user;

import org.ion.client.domain.enumeration.SexType;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/*the person who buys our products
     *TODO separate balance from here?
     */
public class Customer extends Account{
    private final long _balance;
    private final String _address;

    public Customer(String id, String username, String passwordHash, String firstName, String lastName, String email, Boolean isActive, SexType gender, String phoneNumber, Date dateCreated, long balance, String address) {
        super(id, username, passwordHash, firstName, lastName, email, isActive, gender, phoneNumber, dateCreated);
        _balance = balance;
        _address = address;
    }
}