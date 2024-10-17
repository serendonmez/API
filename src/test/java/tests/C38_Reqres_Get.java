package tests;

import baseURL.BaseUrlReqres;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class C38_Reqres_Get extends BaseUrlReqres {

    /*
        https://reqres.in/api/users/2 URL’sine bir GET isteği gönderin.
        Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
        Yanıtın JSON body’sinde yer alan data.id değerinin 2 olduğunu doğrulayın.
        Yanıt süresinin 2 saniyeden kısa olduğunu kontrol edin.
     */

    @Test
    public void test(){

        specUrlReqres.pathParams("pp1","users","pp2","2");

        Response response=given().spec(specUrlReqres).when().get("{pp1}/{pp2}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("data.id",Matchers.equalTo(2));

        Assert.assertTrue("response is very slow",response.getTime()<2000 );

        JsonPath responseJP=response.jsonPath();
        int dataId= responseJP.getInt("data.id");
       // Assert.assertTrue(dataId, Matchers.equalTo());






    }
}
