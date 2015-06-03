package org.ion.client.repository.implementation.postgre;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * // TODO Comment
 */
public abstract class PostgreRepositoryBase {
  private final JdbcTemplate _jdbcTemplate;

  protected PostgreRepositoryBase(JdbcTemplate jdbcTemplate) {
    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setUrl("jdbc:postgresql://localhost:5432/iondb");
    basicDataSource.setUsername("postgres");
    basicDataSource.setPassword("12345");
    _jdbcTemplate = new JdbcTemplate(basicDataSource);
  }
}
