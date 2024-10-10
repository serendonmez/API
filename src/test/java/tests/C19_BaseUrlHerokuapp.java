package tests;

import baseURL.BaseUrlHeroKuApp;
import baseURL.BaseUrlJsonPlaceHolderAPI;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp extends BaseUrlHeroKuApp {



      /*
        Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin
        1-https://restful-booker.herokuapp.com/booking endpointine
        bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu
        ve Response’ta 12 booking oldugunu test edin

        2-https://restful-booker.herokuapp.com/booking endpointine
        yandaki body’ye sahip bir POST request gonderdigimizde
        donen response’un status code’unun 200 oldugunu
        ve “firstname” degerinin “Ahmet” oldugunu test edin
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


    @Test
    public void test1(){
        /*1-https://restful-booker.herokuapp.com/booking endpointine
        bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu
        ve Response’ta 12 booking oldugunu test edin
*/

        //1
                 specHeroKuApp.pathParam("pp1","booking");

            //2

        //3
        Response response=given().when().spec(specHeroKuApp).get("/{pp1}");


        JsonPath jsonPathResponse=response.jsonPath();
      //  System.out.println(jsonPathResponse.getList("bookingid").size());
        //4


        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(3238));












    }
}
