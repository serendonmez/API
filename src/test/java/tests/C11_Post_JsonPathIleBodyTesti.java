package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_Post_JsonPathIleBodyTesti {


    @Test
    public void test(){

        /*
        https://restful-booker.herokuapp.com/booking  url’ine asagidaki body'ye sahip bir POST request
                        gonderdigimizde
                        {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                        "checkin" : "2023-01-10",
                        "checkout" : "2023-01-20"
                                    },
                        "additionalneeds" : "wi-fi"
                        }


                        POST REQUEST, RESPONSE BODY BILGILERINI ASSERT YAPARKEN JSONPATH KULLANMA
                        donen Response’un,
                        status code’unun 200,
                        ve content type’inin application-json,
                        ve response body’sindeki "firstname“in,"Ahmet",
                        ve "lastname“in, "Bulut",
                        ve "totalprice“in,500,
                        ve "depositpaid“in,false,
                        ve "checkin" tarihinin 2023-01-10
                        ve "checkout" tarihinin 2023-01-20
                        ve "additionalneeds“in,"wi-fi"
                        oldugunu test edin
         */


//1

        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookingBilgileri= new JSONObject();
        bookingBilgileri.put("firstname" , "Ahmet");
        bookingBilgileri.put("lastname" , "Bulut");
        bookingBilgileri.put("totalprice" , 500);
        bookingBilgileri.put("depositpaid" , false);

        bookingBilgileri.put( "additionalneeds" , "wi-fi");

        JSONObject bookingdate = new JSONObject();
        bookingdate.put("checkin" , "2023-01-10");
        bookingdate.put("checkout" , "2023-01-20");
        bookingBilgileri.put("bookingdates",bookingdate);

        System.out.println(bookingBilgileri);





        // "checkout":"2023-01-20"


        System.out.println("checkout :"+bookingBilgileri.getJSONObject("bookingdates").get("checkout"));
        //2

        //3
        Response response=given().contentType(ContentType.JSON)
                .when().body(bookingBilgileri.toString()).post(url);
            response.prettyPrint();
          //  response.prettyPeek(); // -> Header bilgilerini getirir


            //4 assert

        /*
             POST REQUEST, RESPONSE BODY BILGILERINI ASSERT YAPARKEN JSONPATH KULLANMA
                        donen Response’un,
                        status code’unun 200,
                        ve content type’inin application-json,
                        ve response body’sindeki "firstname“in,"Ahmet",
                        ve "lastname“in, "Bulut",
                        ve "totalprice“in,500,
                        ve "depositpaid“in,false,
                        ve "checkin" tarihinin 2023-01-10
                        ve "checkout" tarihinin 2023-01-20
                        ve "additionalneeds“in,"wi-fi"
                        oldugunu test edin
         */

            response.then().assertThat()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("booking.firstname", equalTo("Ahmet"),
                            "booking.lastname",equalTo("Bulut"),
                            "booking.totalprice", equalTo(500),
                            "booking.depositpaid", equalTo(false),
                            "booking.bookingdates.checkin", equalTo("2023-01-10"),
                            "booking.bookingdates.checkout",equalTo("2023-01-20"),
                            "booking.additionalneeds",equalTo("wi-fi"));



    }
}
