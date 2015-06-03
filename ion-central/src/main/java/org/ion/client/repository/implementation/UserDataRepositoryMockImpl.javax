package org.ion.client.repository.implementation;

import org.apache.commons.dbcp.BasicDataSource;
import org.ion.client.repository.UserDataRepository;
import org.ion.client.domain.user.Account;
import org.ion.client.domain.user.Customer;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Date;


/**
 * Created by rizkivmaster on 4/24/15.
 */
public class UserDataRepositoryMockImpl implements UserDataRepository {

  //TODO if this project does not fail, please extend the method to be more general

  private final JdbcTemplate _jdbcTemplate;

  public UserDataRepositoryMockImpl() {
    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setUrl("jdbc:postgresql://localhost:5432/iondb");
    basicDataSource.setUsername("postgres");
    basicDataSource.setPassword("12345");
    _jdbcTemplate = new JdbcTemplate(basicDataSource);
  }

  //TODO add result return
  public void insertNewCustomer(String username, String passwordhash, String firstname, String lastname, String email, Boolean isactive, String gender, String phoneNumber, DateTime dateCreated,long balance, String address){
    System.out.println(dateCreated.toString("yyyy-MM-dd"));
      _jdbcTemplate.update("INSERT INTO account values (nextval('account_id_seq'),?,?,?,?,?,?,?,?,?,?,?)", username, passwordhash, firstname, lastname, email, isactive, gender, phoneNumber, new Date(dateCreated.getMillis()), balance, address);
  }

  public void deleteCustomer(String username){
    _jdbcTemplate.update("DELETE FROM account WHERE username = ?",username);
  }

  public void setCustomerAsActive(String username){
    _jdbcTemplate.update(" UPDATE account SET isactive = TRUE WHERE USERNAME = ?",username);
  }

  public void setCustomerBalance(String username, long amount)
  {
    _jdbcTemplate.update("UPDATE account SET balance = ? WHERE username = ?",amount,username);
  }

  @Override
  public void upsertCustomer(Account account) {
    // TODO impl
  }

  @Override
  public Customer getCustomer(String UUID) {
    return null;  // TODO impl
  }

  @Override
  public Customer getCustomerWithEmail(String email) {
    return null;  // TODO impl
  }

  @Override
  public Customer getCustomerWithUsername(String username) {
    return null;  // TODO impl
  }
}
