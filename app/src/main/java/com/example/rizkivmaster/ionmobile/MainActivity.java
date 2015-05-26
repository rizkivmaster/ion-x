package com.example.rizkivmaster.ionmobile;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import org.ionexchange.v1.SexType;
import org.ionexchange.v0.UserRegistrationRequest;
import org.ionexchange.v1.objects.UserRegistrationData;
import org.ionexchange.v1.objects.UserRegistrationCreationResponse;
import org.ionexchange.v1.router.Routers;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Random;


public class MainActivity extends Activity {
  Button btnSubmit,btnCancel;
  EditText edtUsername,edtFirstName,edtLastName,edtEmail,edtGender,edtPhoneNumber,edtAddress;





  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    StrictMode.setThreadPolicy(policy);
    testSendMessage();
/*
    btnSubmit = (Button) findViewById(R.id.submit);
    btnCancel = (Button) findViewById(R.id.cancel);
    edtUsername = (EditText) findViewById(R.id.username);
    edtFirstName = (EditText) findViewById(R.id.firstname);
    edtLastName = (EditText) findViewById(R.id.lastname);
    edtEmail = (EditText) findViewById(R.id.email);
    edtGender = (EditText) findViewById(R.id.gender);
    edtPhoneNumber = (EditText) findViewById(R.id.phonenumber);
    edtAddress = (EditText) findViewById(R.id.address);

    btnSubmit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {


        UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest.Builder()
            .setUsername(edtUsername.getText().toString())
            .setFirstName(edtFirstName.getText().toString())
            .setLastName(edtLastName.getText().toString())
            .setEmail(edtEmail.getText().toString())
            .setAddress(edtAddress.getText().toString())
            .setGender("male".equals(edtGender.getText().toString())?SexType.MALE:SexType.FEMALE)
            .setPhoneNumber(edtPhoneNumber.getText().toString())
            .createUserRegistrationRequest();

        new HttpRequestTask().execute(userRegistrationRequest);
      }
    });


*/

  }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

  private class HttpRequestTask extends AsyncTask<UserRegistrationRequest,Void,Void> {


    @Override
    protected Void doInBackground(UserRegistrationRequest... registrationCreationSpecs) {
      try{
//        final String url1 = "http://192.168.1.70:8080/createtext";
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
//        String response1 = restTemplate.getForObject(url1,String.class,new Object[]{"name=Rizki"});


        final String url2 = "http://192.168.1.70:8080/create";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        UserRegistrationRequest response2 = restTemplate.postForObject(url2,registrationCreationSpecs[0],UserRegistrationRequest.class);

      }
      catch(Exception e)
      {
        Log.e("Not Good", e.getMessage());
      }
      return null;
    }
  }

  private void testSendMessage(){
    int id = createPositiveRandomInt();
    String username = String.valueOf(id);
    String firstName = "Rizki";
    String lastName = "Perdana";
    String email = "rizki@gmail.com";
    String gender = "male";
    String phoneNumber = "800409769834";
    String address = "jalan jalan";
    UserRegistrationData registrationCreationSpec = new UserRegistrationData();
    registrationCreationSpec.setUsername(username);
    registrationCreationSpec.setFirstName(firstName);
    registrationCreationSpec.setLastName(lastName);
    registrationCreationSpec.setEmail(email);
    registrationCreationSpec.setGender(gender.equals("male") ? SexType.MALE : SexType.FEMALE);
    registrationCreationSpec.setPhoneNumber(phoneNumber);
    registrationCreationSpec.setAddress(address);
//    new HttpRequestTask().execute(registrationCreationSpec);
    final String url2 = "http://192.168.1.70:8080"+ Routers.USER_REGISTRATION_CREATION;

    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    UserRegistrationCreationResponse response2 = null;
    try {
       response2 = restTemplate.postForObject(url2, registrationCreationSpec, UserRegistrationCreationResponse.class);
//        assert(registrationCreationSpec.getFirstName().equals(response2.getFirstName()));
      Log.i("success",registrationCreationSpec.getFirstName());
    }
    catch (Exception e)
    {
      Log.e("err", e.getMessage());
    }

  }


  private final Random random = new Random();
  private int createPositiveRandomInt(){
    return random.nextInt(10000);
  }
}
