package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HeroKuurlSil {


    protected static RequestSpecification specUrl;

    @Before
    public void setUp(){

        specUrl=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();



    }





}
