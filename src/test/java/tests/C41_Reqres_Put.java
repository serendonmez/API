package tests;

import baseURL.BaseUrlReqres;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoReqresResponseBody;
import pojos.pojosOpenWeather.PojoOWeather;

import static io.restassured.RestAssured.given;

public class C41_Reqres_Put extends BaseUrlReqres {

    /*

    https://reqres.in/api/users/2 URL'sine bir PUT isteği gönderin.
        Kullanıcıyı şu şekilde güncelleyin: { "name": "John Doe", "job": "Manager" }.
        Yanıtın durum kodunun 200 olduğunu doğrulayın ve name alanının John Doe olduğunu doğrulayın.


 */

    @Test
    public void test(){

        specUrlReqres.pathParams("pp1","users","pp2","2");

        PojoReqresResponseBody requestBody=new PojoReqresResponseBody("John Doe","Manager");


        Response response=given()
                .spec(specUrlReqres)
                .when()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("{pp1}/{pp2}");




        PojoReqresResponseBody responsePojo=response.as(PojoReqresResponseBody.class);



        //   System.out.println(responsePojo); -->PojoReqresResponseBody{name='null', job='null'}

        JsonPath responseJP=response.jsonPath();


        response.then().assertThat().statusCode(200);

        Assert.assertEquals("John Doe",responseJP.getString("name"));




    }
}
