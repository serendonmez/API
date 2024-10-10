package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseDegerleriniAutomationileTestEtme {

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
  status code’unun 200,
 ve content type’inin application/json; charset=utf-8,
 ve Server isimli Header’in degerinin Cowboy,
 ve status Line’in HTTP/1.1 200 OK
 ve resonse suresinin 5 sn den kisa oldugunu test edin
         */

    @Test
    public void test(){

         /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
  status code’unun 200,
 ve content type’inin application/json; charset=utf-8,
 ve Server isimli Header’in degerinin Cowboy,
 ve status Line’in HTTP/1.1 200 OK
 ve resonse suresinin 5 sn den kisa oldugunu test edin
         */

        //1- End point ve request body olustur


        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2- Expected Data hazirlama

        //3- Request gönderip dönen response i kaydetme

        Response response= given().when().get(url);

        //4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");


    }
}
