package testDatalari;

import org.json.JSONObject;

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
}
