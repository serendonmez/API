package tests;

import baseURL.BaseUrlJsonPlaceHolderAPI;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceHolder;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C28_Put_DeSerialization extends BaseUrlJsonPlaceHolderAPI {


    // islem yaptigimiz nesneyi farkli formata döbüstürme islemine
    // Serialization denir. e.g. Java objelerini API sorgulari
    // yapmak üzere Json objesine cevirmeye Serialization denir



    // verilen Json Objesini testlerimizde kullanmak üzere
    // Java objesine cevirmeye ise De-Serialization denir.

    //JSONObject key-value ikililerini kullandigi icin
    // De-Serialization islemi icin Java’dan kullanacagimiz en
    //uygun data turu Map’tir.


    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
     asagidaki body’e sahip bir PUT request yolladigimizda
     donen response’in response body’sinin asagida verilen
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


        // url ve req body hazirla
        specPlaceHolder.pathParams("pp1","posts","pp2",70);

        Map<String, Object> requestBodyMap= TestDataJsonPlaceHolder.bodyOlustur();

        // 2 Expected Data olustur

        Map<String, Object> expectedDataMap=TestDataJsonPlaceHolder.bodyOlustur();


        //3 Req gönder Res kaydet


        Response response=given()
                .spec(specPlaceHolder)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBodyMap)
                .put("/{pp1}/{pp2}");


        //4 assertion
        // expected Response body <===> response
        //     Map                       Response
        // Assertion yapabilmemiz icin Response i Map e cevirmemiz gerekir(De-Serialization)

        Map<String, Object> responseMap= response.as(HashMap.class);

        // expectedData(Map) <=====> responseMap (Map)

        assertEquals(expectedDataMap.get("title"),responseMap.get("title"));
        assertEquals(expectedDataMap.get("userId"),responseMap.get("userId"));
        assertEquals(expectedDataMap.get("id"),responseMap.get("id"));
        assertEquals(expectedDataMap.get("body"),responseMap.get("body"));



    }


}
