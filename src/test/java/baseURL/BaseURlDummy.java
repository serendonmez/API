package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseURlDummy {

   protected RequestSpecification specBaseUrlDummy;

  @Before
  public void setUp(){

      specBaseUrlDummy=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();





  }



}
