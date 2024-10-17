package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlCollectApi {

    protected static RequestSpecification specCollectApi;


    @Before
    public void setUp(){

        specCollectApi =new RequestSpecBuilder().setBaseUri("https://api.collectapi.com/").build();



    }
}
