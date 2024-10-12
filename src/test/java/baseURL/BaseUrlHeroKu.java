package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHeroKu {

    public static RequestSpecification specBaseUrlHero;


    @Before
    public void setUp(){

        specBaseUrlHero=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();





    }



}
