package tests;

import baseURL.BaseUrlReqres;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C40_Reqres_Delete extends BaseUrlReqres {


    /*

     */

    @Test
    public void test(){

        /*
            https://reqres.in/api/users/57 URL'sine bir DELETE isteği gönderin.
       Gelen yanıtın durum kodunun 204 olduğunu doğrulayın.
         */



        specUrlReqres.pathParams("pp1","users","pp2","57");

        Response response=given().when().spec(specUrlReqres).delete("{pp1}/{pp2}");

         response.then().assertThat().statusCode(204).body(Matchers.emptyOrNullString());

                 //.body(Matchers.equalTo(""));



    }




}
