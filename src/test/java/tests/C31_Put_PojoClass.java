package tests;

import baseURL.BaseUrlJsonPlaceHolderAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlaceHolder;
import testDatalari.TestDataJsonPlaceHolder;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;


public class C31_Put_PojoClass extends BaseUrlJsonPlaceHolderAPI {


    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in status kodunun 200,
    content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    response body’sinin asagida verilen
    ile ayni oldugunu test ediniz

     Request Body
        {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
        }

     Expected Data:
        {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
        }


     */


    @Test
    public void test(){

        //1
        specPlaceHolder.pathParams("pp1","posts","pp2","70");


        PojoJsonPlaceHolder requestBodyPojo=
                new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);


        //2 expected Data
        PojoJsonPlaceHolder expectedData=
                new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        //3 Req gönder  Response kaydet

        Response response=given().spec(specPlaceHolder).contentType(ContentType.JSON)
                                    .when().body(requestBodyPojo)
                                    .put("/{pp1}/{pp2}");



        //4 assertion

        // expectedData (Pojo) -------response (Response)

        PojoJsonPlaceHolder responsePojo= response.as(PojoJsonPlaceHolder.class);

        // expectedData (Pojo) -------responsePojo (Pojo)


        /*
         status kodunun 200,
    content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
         */

       assertEquals( TestDataJsonPlaceHolder.basariliSorguStatusCode, response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType, response.contentType());
        assertEquals(TestDataJsonPlaceHolder.headerConnection,response.header("Connection"));
        assertEquals(expectedData.getTitle(),responsePojo.getTitle());
        assertEquals(expectedData.getBody(),responsePojo.getBody());
        assertEquals(expectedData.getUserId(),responsePojo.getUserId());
        assertEquals(expectedData.getId(),responsePojo.getId());



    }
}
