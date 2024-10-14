package tests;

import baseURL.BaseUrlHeroKuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import org.junit.Assert;
import org.junit.Test;
import pojos.PojoHeroKuAppBookingDates;
import pojos.PojoHeroKuAppRequestBody;
import pojos.PojoHeroKuAppResponseBody;
import testDatalari.TestDatalariHeroKu;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;



public class C32_Post_Pojo extends BaseUrlHeroKuApp {


    /*
    https://restful-booker.herokuapp.com/booking url’ine asagidaki
    body'ye sahip bir POST request gonderdigimizde donen response’un
     status kodunun 200,
    content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive” ve
    bodynin id haric asagidaki gibi oldugunu test edin.


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
     */
@Test
    public void test(){

        //1 url ve req body hazirla

        specHeroKuApp.pathParam("pp1","booking");

        PojoHeroKuAppBookingDates bookingDates=new PojoHeroKuAppBookingDates("2021-06-01","2021-06-10");

        PojoHeroKuAppRequestBody requestBody=new PojoHeroKuAppRequestBody("Ahmet","Bulut",
                500,false,bookingDates,"wi-fi");

        //2 expected Data olustur

        PojoHeroKuAppResponseBody expectedDataResponseBody=new PojoHeroKuAppResponseBody(3155, requestBody);




        //3 Req gönder res kaydet

        Response response=given()
                                    .when().spec(specHeroKuApp).contentType(ContentType.JSON)
                                    .body(requestBody)
                                    .post("/{pp1}");


        //4- Assertion

        // expectedata (PojoHeroKuAppResponseBody) ---- response (Response)

        PojoHeroKuAppResponseBody responsePojo=response.as(PojoHeroKuAppResponseBody.class);

       assertEquals(TestDatalariHeroKu.basarilistatusCode,response.statusCode());
       assertEquals(TestDatalariHeroKu.contentType,response.contentType());
       assertEquals(TestDatalariHeroKu.header,response.header("Connection"));

       assertEquals(expectedDataResponseBody.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
       assertEquals(expectedDataResponseBody.getBooking().getLastname(),responsePojo.getBooking().getLastname());
       assertEquals(expectedDataResponseBody.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
       assertEquals(expectedDataResponseBody.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());
       assertEquals(expectedDataResponseBody.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
       assertEquals(expectedDataResponseBody.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());
       assertEquals(expectedDataResponseBody.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());
















    }


}
