package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseURlDummyExm {


    public static RequestSpecification specDummyUrl;


    @Before
    public void setUp(){

        specDummyUrl= new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();



    }
}
