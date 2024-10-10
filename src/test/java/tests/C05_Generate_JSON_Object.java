package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C05_Generate_JSON_Object {

    @Test
    public void test(){
     /*
     {
    "firstname": "Mary",
    "lastname": "Smith",
    "totalprice": 841,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2017-04-30",
        "checkout": "2020-11-28"
    },
    "additionalneeds": "Breakfast"
}
      */
        // önce inner Json objesini olusturduk.
        JSONObject dateObj = new JSONObject();
        dateObj.put("checkin","2017-04-30");
        dateObj.put("checkout","2020-11-28");

        // sonra outer Json object olusturduk.
        JSONObject obj = new JSONObject();

        obj.put("firstname","Mary");
        obj.put("lastname", "Smith");
        obj.put("totalprice", 841);
        obj.put("depositpaid", false);
        obj.put("bookingdates", dateObj);
        obj.put("additionalneeds", "Breakfast");
        System.out.println(obj);


    }
}
