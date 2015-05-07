package accessor;

import org.ion.client.domain.user.Customer;
import org.joda.time.DateTime;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * // TODO Comment
 */
public class CustomerDataAccessorTest extends AccessorTestBase {

  @Test
  public void customerDataAccessorBasicTest() throws Exception {
    {
      getCustomerDataAccessorImpl().insertNewCustomer(
          "aminudin",
          "4h3k2bkfba",
          "Amin",
          "Nudin",
          "aminudin@gmail.com",
          false,
          "male",
          "081753829523",
          new DateTime(),
          0L,
          "Jalan Bakauheni"
      );
    }

    {
      Customer customerAdded = getCustomerDataAccessorImpl().readCustomerByUsername("aminudin");
      assertNotNull(customerAdded);
      assertEquals("4h3k2bkfba", customerAdded.getPasswordHash());
    }

    {
      Customer customer1 = getCustomerDataAccessorImpl().readCustomerByUsername("aminudin");
      assertFalse(customer1.isActive());
      getCustomerDataAccessorImpl().setCustomerAsActive("aminudin");
      Customer customer2 = getCustomerDataAccessorImpl().readCustomerByUsername("aminudin");
      assertNotNull(customer2);
      assertTrue(customer2.isActive());
    }

    {
      Customer customer1 = getCustomerDataAccessorImpl().readCustomerByUsername("aminudin");
      long balance = createPositiveRandomInt();
      getCustomerDataAccessorImpl().setCustomerBalance(customer1.getUsername(),balance);
      Customer customer2 = getCustomerDataAccessorImpl().readCustomerByUsername("aminudin");
      assertNotNull(customer2);
      assertEquals(balance,customer2.getBalance());
    }

    {
      getCustomerDataAccessorImpl().deleteCustomer("aminudin");
      Customer customerDeleted = getCustomerDataAccessorImpl().readCustomerByUsername("aminudin");
      assertNull(customerDeleted);
    }
  }
}
