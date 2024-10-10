package tests;

import baseURL.BaseUrlHeroKuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHeroKuApp extends BaseUrlHeroKuApp {

    /*
     2-https://restful-booker.herokuapp.com/booking endpointine
        asagidaki gibi body’ye sahip bir POST request gonderdigimizde
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
    public void test() {

        //1 url ve Request body olustur


        specHeroKuApp.pathParam("pp1", "booking");

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2021-06-01");
        bookingDates.put("checkout", "2021-06-10");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates", bookingDates);
        requestBody.put("additionalneeds", "wi-fi");

        System.out.println(requestBody);


        //2
        //3
        Response response = given().contentType(ContentType.JSON)
                .when().spec(specHeroKuApp).body(requestBody.toString())
                .post("/{pp1}");
       // response.prettyPrint();

        //4

        /*

        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonPathResponse=response.jsonPath();
        softAssert.assertEquals(jsonPathResponse.get("firstname"),requestBody.get("firstname"));

        response.then().assertThat().statusCode(200);

         */

            response.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("Ahmet"));


    }

}
