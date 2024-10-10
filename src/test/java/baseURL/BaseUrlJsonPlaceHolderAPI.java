package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlJsonPlaceHolderAPI {

    protected RequestSpecification specPlaceHolder;

    @Before
    public void setUp(){

        specPlaceHolder=new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();




    }


}
