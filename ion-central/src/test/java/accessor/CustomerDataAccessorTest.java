package accessor;

import org.ion.client.domain.enumeration.SexType;
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
      getCustomerDataAccessor().insertNewCustomer(
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
      Customer customerAdded = getCustomerDataAccessor().readCustomerByUsername("aminudin");
      assertNotNull(customerAdded);
      assertEquals("4h3k2bkfba", customerAdded.getPasswordHash());
    }

    {
      Customer customer1 = getCustomerDataAccessor().readCustomerByUsername("aminudin");
      assertFalse(customer1.isActive());
      getCustomerDataAccessor().setCustomerAsActive("aminudin");
      Customer customer2 = getCustomerDataAccessor().readCustomerByUsername("aminudin");
      assertNotNull(customer2);
      assertTrue(customer2.isActive());
    }

    {
      Customer customer1 = getCustomerDataAccessor().readCustomerByUsername("aminudin");
      long balance = createPositiveRandomInt();
      getCustomerDataAccessor().setCustomerBalance(customer1.getUsername(),balance);
      Customer customer2 = getCustomerDataAccessor().readCustomerByUsername("aminudin");
      assertNotNull(customer2);
      assertEquals(balance,customer2.getBalance());
    }

    {
      getCustomerDataAccessor().deleteCustomer("aminudin");
      Customer customerDeleted = getCustomerDataAccessor().readCustomerByUsername("aminudin");
      assertNull(customerDeleted);
    }
  }
}
