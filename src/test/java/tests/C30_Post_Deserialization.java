package tests;

import baseURL.HeroKuurlSil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDatalariHeroKu;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C30_Post_Deserialization extends HeroKuurlSil {

    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki
     body'ye sahip bir POST request gonderdigimizde donen
      response’un id haric asagidaki gibi oldugunu test edin.

      Request Body

      {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
                        "checkin": "2021-06-01",
                        "checkout": "2021-06-10"
                        },
        "additionalneeds": "wi-fi"
    }


    Response Body // expected data

      {
                "bookingid": 3155,
                "booking": {
                            "firstname": "Ahmet",
                            "lastname": "Bulut",
                            "totalprice": 500,
                            "depositpaid": false,
                            "bookingdates": {
                                                "checkin": "2021-06-01",
                                                "checkout": "2021-06-10"
                                             },
                            "additionalneeds": "wi-fi"
                            }
        }


     */

    @Test
    public void test(){

        //1
        specUrl.pathParam("pp1","booking");

        Map<String, Object> requestBodyMap= TestDatalariHeroKu.reqBodyMapOlustur("Ahmet","Bulut",
                500.0,false,"2021-06-01","2021-06-10","wi-fi");

        //2 Expected Data

        Map<String, Object> expectedData = new HashMap<>();

        expectedData.put("bookingid",3517);
        expectedData.put("booking",requestBodyMap);


        //3
        Response response= given()
                .spec(specUrl)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBodyMap)
                .post("/{pp1}");

        //4
        Map<String, Object> responseMap=response.as(HashMap.class);


        assertEquals(((Map)(expectedData.get("booking"))).get("firstname"),
                ((Map)responseMap.get("booking")).get("firstname"));
        assertEquals(((Map)(expectedData.get("booking"))).get("lastname"),
                ((Map)responseMap.get("booking")).get("lastname"));
        assertEquals(((Map)(expectedData.get("booking"))).get("totalprice"),
                ((Map)responseMap.get("booking")).get("totalprice"));
        assertEquals(((Map)(expectedData.get("booking"))).get("depositpaid"),
                ((Map)responseMap.get("booking")).get("depositpaid"));
        assertEquals(((Map)(((Map)(expectedData.get("booking"))).get("bookingdates"))).get("checkin"),
                ((Map)((Map)responseMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)(((Map)(expectedData.get("booking"))).get("bookingdates"))).get("checkout"),
                ((Map)((Map)responseMap.get("booking")).get("bookingdates")).get("checkout"));
        assertEquals((((Map)(expectedData.get("booking"))).get("additionalneeds")),
                ((Map)responseMap.get("booking")).get("additionalneeds"));



    }
}
