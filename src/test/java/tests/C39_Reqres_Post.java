package tests;

import baseURL.BaseUrlReqres;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C39_Reqres_Post extends BaseUrlReqres {


    @Test
    public void test(){
        /*
        https://reqres.in/api/users URL'sine
    header derğeri "Content-Type", "application/json" olan bir POST isteği gönderin.
    İstek için JSON formatında şu bilgileri içeren bir body kullanın:
     {
     "name": "morpheus",
     "job": "leader"
     }
    Gelen yanıtın durum kodunun 201 olduğunu doğrulayın.
    Yanıtın JSON body'sinde name alanının morpheus olduğunu kontrol edin.
         */

        specUrlReqres.pathParams("pp1","users");


        JSONObject requestBody=new JSONObject();
        requestBody.put("name","morpheus");
        requestBody.put("job","leader");
        requestBody.put("id", "856");
        requestBody.put("createdAt", "2024-10-17T08:27:42.590Z");


        //String reqBody="{\"name\" :\"morpheus\",\"job\":\"leader\"}";

        System.out.println(requestBody);


        Response response=given()
                .spec(specUrlReqres)
                .when().contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post("/{pp1}");
        response.prettyPrint();

        JsonPath responseJP=response.jsonPath();

        response.then().assertThat().statusCode(201);
        Assert.assertEquals("morpheus",responseJP.getString("name"));


        //"2024-10-17T08:32:43.803Z",

        //2024-10-17T08:33:42.463Z"







    }
}
