package org.ion.client.accessors;

import org.apache.commons.dbcp.BasicDataSource;
import org.ion.client.domain.Invoice;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * // TODO Comment
 */
public class InvoiceDataAccessor {


  private final JdbcTemplate _jdbcTemplate;

  public InvoiceDataAccessor(){
    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setUrl();
  }

  public void  insertNewInvoice(String issuerUsername,String issuedUsername, String subject, String description, long amount, boolean hasPaid){

  }

  public Invoice getInvoice(long userInvoiceId){
    return null;
  }

  public void setInvoicePaymentStatus(long userInvoiceId, boolean isPaid)
  {

  }

}
