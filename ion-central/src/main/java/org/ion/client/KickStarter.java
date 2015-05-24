package org.ion.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by rizkivmaster on 4/25/15.
 */
@SpringBootApplication
public class KickStarter implements CommandLineRunner {
  public static void main(String[] args){
    SpringApplication.run(KickStarter.class,args);
  }


  @Override
  public void run(String... args) throws Exception {
    System.out.println("system is running well");
    IONComponent ionComponent = new IONComponent();
//    UserDataService userDataService = ionComponent.getUserDataService();
//    Builder registrationCreationSpecBuilder = new Builder();
//    RegistrationCreationSpec registrationCreationSpec = registrationCreationSpecBuilder.setUsername("test").setEmail("test@gmail.com").createRegistrationCreationSpec();
//    userDataService.createUserRegistration(registrationCreationSpec);
//    CustomerReadDetailSpec customerReadDetailSpec = new CustomerReadDetailSpec("test");
//    CustomerReadDetailResult customerReadDetailResult = userDataService.readCustomerDetail(customerReadDetailSpec);
//    System.out.println(customerReadDetailResult.getCustomer().getEmail());
//    assert(customerReadDetailResult.getCustomer().getEmail().equals(registrationCreationSpec.getEmail()));
  }
}
