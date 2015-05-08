package org.ion.client.accessors;

import org.apache.commons.dbcp.BasicDataSource;
import org.ion.client.domain.enumeration.SexType;
import org.ion.client.domain.user.Customer;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by rizkivmaster on 4/24/15.
 */
public class AccountDataAccessorImpl implements AccountDataAccessor {

  //TODO if this project does not fail, please extend the method to be more general

  private final JdbcTemplate _jdbcTemplate;

  public AccountDataAccessorImpl() {
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

  public Customer readCustomerById(long id){
    List<Customer> results = _jdbcTemplate.query(
        "select * from account WHERE id = ?",new Object[]{id},
        new RowMapper<Customer>() {
          @Override
          public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Customer(String.valueOf(rs.getLong("id")), rs.getString("username"),rs.getString("passwordhash"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getBoolean("isactive"),rs.getString("gender").equals("male")? SexType.MALE:SexType.FEMALE,rs.getString("phonenumber"),DateTime.parse(rs.getDate("datecreated").toString()),rs.getLong("balance"),rs.getString("address"));
          }
        });
    return results.isEmpty()?null:results.get(0);
  }

  public Customer readCustomerByUsername(String username){
    List<Customer> results = _jdbcTemplate.query(
        "select * from account WHERE username = ?",new Object[]{username},
        new RowMapper<Customer>() {
          @Override
          public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Customer(String.valueOf(rs.getLong("id")), rs.getString("username"),rs.getString("passwordhash"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getBoolean("isactive"),rs.getString("gender").equals("male")? SexType.MALE:SexType.FEMALE,rs.getString("phonenumber"),DateTime.parse(rs.getDate("datecreated").toString()),rs.getLong("balance"),rs.getString("address"));
          }
        });
    return results.isEmpty()?null:results.get(0);
  }

  public List<Customer> getCustomers(){
    List<Customer> results = _jdbcTemplate.query(
        "select * from account",
        new RowMapper<Customer>() {
          @Override
          public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Customer(String.valueOf(rs.getLong("id")), rs.getString("username"),rs.getString("passwordhash"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getBoolean("isactive"),rs.getString("gender").equals("male")? SexType.MALE:SexType.FEMALE,rs.getString("phonenumber"),DateTime.parse(rs.getDate("datecreated").toString()),rs.getLong("balance"),rs.getString("address"));
          }
        });
    return results;
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
  public void upsertCustomer(Customer customer) {
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
