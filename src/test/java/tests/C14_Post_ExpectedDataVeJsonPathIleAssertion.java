package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import static org.testng.AssertJUnit.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void test(){

        /*
        https://restful-booker.herokuapp.com/booking   url’ine asagidaki body'ye sahip bir POST request
         gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
         POST REQUEST, RESPONSE BODY BILGILERINI ASSERT YAPARKEN JSONPATH KULLANMA
         Response Body
          {
               "bookingid":24,
                    "booking":
                   { "firstname":"Ahmet",
                      "lastname":"Bulut",
                      "totalprice":500,
                      "depositpaid":false,
                      "bookingdates":
                      {"checkin":"2021-06-01",
                         "checkout":"2021-06-10"
                       },
                    "additionalneeds":"wi-fi"
                   }
           }

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

        //1
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject bookingdates =new JSONObject();
        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        JSONObject requestObj= new JSONObject();
        requestObj.put("firstname", "Ahmet");
        requestObj.put("lastname" ,"Bulut");
        requestObj.put("totalprice" , 500);
        requestObj.put("depositpaid", false);
        requestObj.put("bookingdates",bookingdates);
        requestObj.put("additionalneeds", "wi-fi");



        //2
        JSONObject expectedData=new JSONObject();
        expectedData.put("bookingid",24);
        expectedData.put("booking",requestObj);


        // 3


        Response response= given().contentType(ContentType.JSON)
                .when().body(requestObj.toString())
                .post(url);





        // Assertion

        JsonPath responseJsonPath=response.jsonPath();

        // Expected= Olusturdugumuz Json Object -> expectedData
        // Actual = Response -> responseJsonPath

        Assert.assertEquals(
                expectedData.getJSONObject("booking").get("firstname"),
                responseJsonPath.get("booking.firstname"));

        assertEquals(expectedData.getJSONObject("booking").get("lastname"),responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),responseJsonPath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),responseJsonPath.get("booking.bookingdates.checkout"));















    }
}
