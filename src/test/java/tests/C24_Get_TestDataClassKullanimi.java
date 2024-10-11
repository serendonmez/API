package tests;

import baseURL.BaseUrlJsonPlaceHolderAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import testDatalari.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C24_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceHolderAPI {

    @Test
    public void test(){
        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda donen response’in
        status kodunun 200
        ve response body’sinin asagida verilen ile ayni oldugunu
        test ediniz
            Response body :

         {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
         }

     */
        // End point ve Request body hazirla

        specPlaceHolder.pathParams("pp1","posts","pp2",22);

        //2 expected data olustur
        JSONObject expectedData=  TestDataJsonPlaceHolder.responseJsonBodyOlustur(3,22,"dolor sint quo a velit explicabo quia nam",
        "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


        //3 request gönder response kaydet
        Response response=given().spec(specPlaceHolder)
                .when()
                .get("/{pp1}/{pp2}");

        //4 Assertion


        JsonPath jsonPathResponse= response.jsonPath();
        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode, response.statusCode());
        assertEquals(expectedData.getInt("userId"),jsonPathResponse.getInt("userId"));
        assertEquals(expectedData.getInt("id"), jsonPathResponse.getInt("id"));
        assertEquals(expectedData.getString("title"),jsonPathResponse.getString("title"));
        assertEquals(expectedData.getString("body"), jsonPathResponse.getString("body"));




    }
}
