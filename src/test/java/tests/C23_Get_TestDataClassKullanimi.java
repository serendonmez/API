package tests;

import baseURL.BaseUrlJsonPlaceHolderAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C23_Get_TestDataClassKullanimi extends BaseUrlJsonPlaceHolderAPI {


    @Test
    public void test(){

                /*
                https://jsonplaceholder.typicode.com/posts/22
                url'ine bir GET request yolladigimizda donen
                response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest
                ediniz
                         Response body :
                          {
                                "userId": 3,
                                "id": 22,
                                "title": "dolor sint quo a velit explicabo quia nam",
                                "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita
                                           earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
                          }
                 */

        //1 Request body ve end point olustur

        specPlaceHolder.pathParams("pp1","posts","pp2","22");

        //2 Expected data olustur
        JSONObject expectedData= TestDataJsonPlaceHolder.responsBodyOlustur22();



        //3 Request gönder ve dönen response i kaydet

        Response response=given().when().spec(specPlaceHolder).get("/{pp1}/{pp2}");

       // response.prettyPrint();

        //4 Assert

        JsonPath jsonPathResponse=response.jsonPath();

        Assert.assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode, response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"), jsonPathResponse.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"), jsonPathResponse.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),jsonPathResponse.getString("title"));
        Assert.assertEquals(expectedData.getString("body"), jsonPathResponse.getString("body"));




    }
}
