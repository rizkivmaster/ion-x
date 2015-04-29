package org.ion.client.accessors;

import org.apache.commons.dbcp.BasicDataSource;
import org.ion.client.domain.enumeration.SexType;
import org.ion.client.domain.user.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;


/**
 * Created by rizkivmaster on 4/24/15.
 */
public class CustomerDataAccessor {

  @Autowired
  private final JdbcTemplate _jdbcTemplate;

  public CustomerDataAccessor() {
    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setUrl("jdbc:postgresql://localhost:5432/iondb");
    basicDataSource.setUsername("postgres");
    basicDataSource.setPassword("12345");
    _jdbcTemplate = new JdbcTemplate(basicDataSource);
  }

  //TODO add result return
  public void insertNewCustomer(String username, String passwordhash, String firstname, String lastname, String email, Boolean isactive, String gender, String phoneNumber, Date dateCreated, String address){
      _jdbcTemplate.update("INSERT INTO account values (nextval('account_id_seq'),?,?,?,?,?,true,?,?,'2015-04-15',0,?)",username,passwordhash,firstname,lastname,email,gender,phoneNumber,address);
  }

  public Customer readCustomerById(long id){
    List<Customer> results = _jdbcTemplate.query(
        "select * from account WHERE id = ?",new Object[]{id},
        new RowMapper<Customer>() {
          @Override
          public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Customer(String.valueOf(rs.getLong("id")), rs.getString("username"),rs.getString("passwordhash"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getBoolean("isactive"),rs.getString("gender").equals("male")? SexType.MALE:SexType.FEMALE,rs.getString("phonenumber"),rs.getDate("datecreated"),rs.getLong("balance"),rs.getString("address"));
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
            return new Customer(String.valueOf(rs.getLong("id")), rs.getString("username"),rs.getString("passwordhash"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getBoolean("isactive"),rs.getString("gender").equals("male")? SexType.MALE:SexType.FEMALE,rs.getString("phonenumber"),rs.getDate("datecreated"),rs.getLong("balance"),rs.getString("address"));
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
            return new Customer(String.valueOf(rs.getLong("id")), rs.getString("username"),rs.getString("passwordhash"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getBoolean("isactive"),rs.getString("gender").equals("male")? SexType.MALE:SexType.FEMALE,rs.getString("phonenumber"),rs.getDate("datecreated"),rs.getLong("balance"),rs.getString("address"));
          }
        });
    return results;
  }
}
