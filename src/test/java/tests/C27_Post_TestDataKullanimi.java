package tests;

import baseURL.BaseUrlHeroKu;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDatalariHeroKu;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.testng.AssertJUnit.assertEquals;

public class C27_Post_TestDataKullanimi extends BaseUrlHeroKu {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id haric asagidaki gibi oldugunu test edin.



             Request body
            {
                    "firstname" : "Ahmet",
                    "lastname" : “Bulut",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                                        "checkin" : "2021-06-01",
                                        "checkout" : "2021-06-10"
                                      },
                    "additionalneeds" : "wi-fi"
            }


            Response Body
            {
                    "bookingid":24,
                    "booking":
                                {
                                    "firstname":"Ahmet",
                                    "lastname":"Bulut",
                                    "totalprice":500,
                                    "depositpaid":false,
                                    "bookingdates":
                                                     {
                                                         "checkin":"2021-06-01",
                                                         "checkout":"2021-06-10"
                                                      },
                                    "additionalneeds":"wi-fi"
                                 }
             }

     */


    @Test
    public void test(){

        //1 url request hazirlama

        specBaseUrlHero.pathParam("pp1","booking");
        /*
        Request body
            {
                    "firstname" : "Ahmet",
                    "lastname" : “Bulut",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                                        "checkin" : "2021-06-01",
                                        "checkout" : "2021-06-10"
                                      },
                    "additionalneeds" : "wi-fi"
            }
         */

        JSONObject requestBody= TestDatalariHeroKu.responseBodyOlustur("Ahmet","Bulut",
                500, false,"2021-06-01", "2021-06-10","wi-fi");



        //2 Expected data olustur

        JSONObject expectedData= new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",TestDatalariHeroKu.responseBodyOlustur("Ahmet","Bulut",
                500,false,"2021-06-01", "2021-06-10","wi-fi"));



        //3 Req gönder Resp kaydet

        Response response= given().when().spec(specBaseUrlHero).contentType(ContentType.JSON).body(requestBody.toString()).post("/{pp1}");




        //4 assertion

        JsonPath jsonPathResponse= response.jsonPath();
        /*
         Response Body
            {
                    "bookingid":24,
                    "booking":
                                {
                                    "firstname":"Ahmet",
                                    "lastname":"Bulut",
                                    "totalprice":500,
                                    "depositpaid":false,
                                    "bookingdates":
                                                     {
                                                         "checkin":"2021-06-01",
                                                         "checkout":"2021-06-10"
                                                      },
                                    "additionalneeds":"wi-fi"
                                 }
             }
         */

     assertEquals(expectedData.getJSONObject("booking").getString("firstname"),jsonPathResponse.get("booking.firstname"));
     assertEquals(expectedData.getJSONObject("booking").getString("lastname"),jsonPathResponse.get("booking.lastname"));
     assertEquals(expectedData.getJSONObject("booking").getInt("totalprice"),jsonPathResponse.getInt("booking.totalprice"));
     assertEquals(expectedData.getJSONObject("booking").getBoolean("depositpaid"),jsonPathResponse.getBoolean("booking.depositpaid"));
     assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin")
             ,jsonPathResponse.get("booking.bookingdates.checkin"));
     assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout")
             ,jsonPathResponse.get("booking.bookingdates.checkout"));
        assertEquals(expectedData.getJSONObject("booking").getString("additionalneeds"),jsonPathResponse.get("booking.additionalneeds"));








    }




}
