package tests;

import baseURL.BaseUrlJsonPlaceHolderAPI;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C25_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceHolderAPI {

    /*
            https://jsonplaceholder.typicode.com/posts/70
        url'ine asagidaki body’e sahip bir PUT request
        yolladigimizda donen response’in status kodunun 200,
        content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz


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
    public void Test(){

        //1 . Url ve Request body olustur

        specPlaceHolder.pathParams("pp1","posts","pp2","70");

        JSONObject requestBody=TestDataJsonPlaceHolder.responseJsonBodyOlustur(10,70,"Ahmet","Merhaba");

        //2 expected data hazirla

        JSONObject expectedData= TestDataJsonPlaceHolder.responseJsonBodyOlustur(10,70,"Ahmet","Merhaba");


        //3 Request gönder Response kaydet

        Response response=given().contentType(ContentType.JSON).spec(specPlaceHolder).when().body(requestBody.toString()).put("/{pp1}/{pp2}");
        response.prettyPrint();


        //4 Assert
        JsonPath jsonPathResponse=response.jsonPath();

        Assert.assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());
        Assert.assertEquals(TestDataJsonPlaceHolder.contentType, response.contentType());
        Assert.assertEquals(TestDataJsonPlaceHolder.headerConnection, response.header("Connection"));
         Assert.assertEquals(expectedData.getInt("userId"), jsonPathResponse.getInt("userId"));
         Assert.assertEquals(expectedData.getInt("id"), jsonPathResponse.getInt("id"));
         Assert.assertEquals(expectedData.getString("title"), jsonPathResponse.getString("title"));
         Assert.assertEquals(expectedData.getString("body"), jsonPathResponse.getString("body"));











    }




}
