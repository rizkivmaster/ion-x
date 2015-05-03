package org.ion.client.domain.user;

import org.ion.client.domain.enumeration.SexType;
import org.joda.time.DateTime;

import java.sql.Time;
import java.util.Date;

/**
    *
    */
public abstract class Account{
        private final String _id;
        private final String _username;
        private final String _passwordHash;
        private final String _firstName;
        private final String _lastName;
        private final String _email;
        private final Boolean _isActive;
        private final SexType _gender;
        private final String _phoneNumber;
        private final DateTime _dateCreated;

        public Account(String id, String username, String passwordHash, String firstName, String lastName, String email, Boolean isActive, SexType gender, String phoneNumber, DateTime dateCreated) {
                _id = id;
                _username = username;
                _passwordHash = passwordHash;
                _firstName = firstName;
                _lastName = lastName;
                _email = email;
                _isActive = isActive;
                _gender = gender;
                _phoneNumber = phoneNumber;
                _dateCreated = dateCreated;
        }


        public String toString(){
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[ ");
                stringBuilder.append(_id);
                stringBuilder.append(", ");
                stringBuilder.append(_username);
                stringBuilder.append(", ");
                stringBuilder.append(_passwordHash);
                stringBuilder.append(", ");
                stringBuilder.append(_firstName);
                stringBuilder.append(", ");
                stringBuilder.append(_lastName);
                stringBuilder.append(", ");
                stringBuilder.append(_email);
                stringBuilder.append(", ");
                stringBuilder.append(_isActive);
                stringBuilder.append(", ");
                stringBuilder.append(_gender);
                stringBuilder.append(", ");
                stringBuilder.append(_phoneNumber);
                stringBuilder.append(", ");
                stringBuilder.append(_dateCreated);
                stringBuilder.append(" ]");
                return stringBuilder.toString();
        }


        public String getId() {
                return _id;
        }

        public String getUsername() {
                return _username;
        }

        public String getPasswordHash() {
                return _passwordHash;
        }

        public String getFirstName() {
                return _firstName;
        }

        public String getLastName() {
                return _lastName;
        }

        public String getEmail() {
                return _email;
        }

        public Boolean isActive() {
                return _isActive;
        }

        public SexType getGender() {
                return _gender;
        }

        public String getPhoneNumber() {
                return _phoneNumber;
        }

        public DateTime getDateCreated() {
                return _dateCreated;
        }

}
