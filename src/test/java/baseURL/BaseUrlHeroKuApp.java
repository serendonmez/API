package baseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHeroKuApp {


    protected RequestSpecification specHeroKuApp;

    @Before
    public void setUp(){

        specHeroKuApp=new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();








    }


}
