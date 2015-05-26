/*
package services;

import org.ion.client.IONComponent;
import org.ion.client.domain.enumeration.SexType;
import org.ion.client.services.UserDataService;
import org.ion.client.services.util.CustomerReadDetailResult;
import org.ion.client.services.util.CustomerReadDetailSpec;
import org.ion.client.services.util.RegistrationCreationSpec;
import org.ionexchange.v0.UserRegistrationRequest;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

*/
/**
 * Created by rizkivmaster on 4/25/15.
 *//*


@Test
public class UserDataServiceIntegrationTest extends IONServiceIntegrationTestBase {



  @Test
  public void userDataServiceBasicTest(){
    IONComponent ionComponent = new IONComponent();
    UserDataService userDataService = ionComponent.getUserDataService();
    RegistrationCreationSpec registrationCreationSpec = new RegistrationCreationSpec.Builder()
        .setUsername("rosto")
        .setFirstName("Rosto")
        .setLastName("Vandiesel")
        .setEmail("test@gmail.com")
        .setGender(SexType.MALE)
        .setPhoneNumber("0812412453")
        .setAddress("Jalan Aksara")
        .createRegistrationCreationSpec();
    userDataService.createNewUser(registrationCreationSpec);
    CustomerReadDetailSpec customerReadDetailSpec = new CustomerReadDetailSpec("rosto");
    CustomerReadDetailResult customerReadDetailResult = userDataService.readCustomerDetail(customerReadDetailSpec);
    assertEquals(customerReadDetailResult.getCustomer().getPhoneNumber(),registrationCreationSpec.getPhoneNumber());
  }


  @Test
  public void testUserAddController(){
    IONComponent ionComponent = new IONComponent();
    UserDataService userDataService = ionComponent.getUserDataService();
    UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest.Builder()
        .setUsername("rosto"+String.valueOf(createPositiveRandomInt()))
        .setFirstName("Rosto")
        .setLastName("Vandiesel")
        .setEmail("test@gmail.com")
        .setGender(org.ionexchange.v1.SexType.MALE)
        .setPhoneNumber("0812412453")
        .setAddress("Jalan Aksara")
        .createUserRegistrationRequest();
//    userDataService.createNewUser(registrationCreationSpec);
//    CustomerReadDetailResult customerReadDetailResult = userDataService.readCustomerDetail(customerReadDetailSpec);
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
//    String result = restTemplate.getForObject("http://localhost:8080/createtext", String.class,var);
    UserRegistrationRequest result = restTemplate.postForObject("http://localhost:8080/create", userRegistrationRequest,UserRegistrationRequest.class);
    result.getFirstName();
//    assert(customerReadDetailResult.getCustomer().getEmail().equals(registrationCreationSpec.getEmail()));
  }

}*/
