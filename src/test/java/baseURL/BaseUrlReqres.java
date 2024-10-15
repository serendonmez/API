package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlReqres {

    protected RequestSpecification specUrlReqres;

    @Before
    public void setUp(){

        specUrlReqres=new RequestSpecBuilder().setBaseUri("https://reqres.in/api/").build();


    }


}
