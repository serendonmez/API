package testDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDatalariHeroKu {



    public static JSONObject responseBodyOlustur(String firstname, String lastname,
                                                 int totalprice, boolean depositpaid,
                                              String checkin,
                                                 String checkout, String additionalneeds ){


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

        JSONObject bookingDates =new JSONObject();
        bookingDates.put("checkin",checkin);
        bookingDates.put("checkout",checkout);

        JSONObject expectedData= new JSONObject();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingDates);
        expectedData.put("additionalneeds", additionalneeds);





        return expectedData;

    }


    public static Map<String, Object> reqBodyMapOlustur(String firstname, String lastname , Double totalprice,
                                                  Boolean depositpaid, String checkin,String checkout,
                                                  String additionalneeds){

        /*
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
         */


        Map<String, Object> requestBodyMap= new HashMap<>();
        requestBodyMap.put("firstname",firstname);
        requestBodyMap.put("lastname",lastname);
        requestBodyMap.put("totalprice",totalprice);
        requestBodyMap.put("depositpaid",depositpaid);
        requestBodyMap.put("bookingdates",bookingDatesMapOlustur(checkin,checkout));
        requestBodyMap.put("additionalneeds",additionalneeds);

    return requestBodyMap;
    }

    public static Map<String, String > bookingDatesMapOlustur(String checkin,String  checkout){

        Map<String, String> bookingDatesMap=new HashMap<>();
        bookingDatesMap.put("checkin", checkin);
        bookingDatesMap.put("checkout", checkout);


        return bookingDatesMap;

    }



}
