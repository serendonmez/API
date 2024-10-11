package testDatalari;

import org.json.JSONObject;

public class TestDatalariDummy {


    public static int statusCode=200;
    public static String contentType="application/json";



    public static JSONObject responseBodyOlustur(String status,
                                                 int dataId, String employee_name,
                                                 int employee_salary,int employee_age, String profile_image,
                                                 String message){



        /*
         Response Body
    {
        "status":"success",
        "data":
                {
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000,
                    "employee_age":66,
                    "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
     }
         */

        JSONObject data =new JSONObject();
        data.put("id",dataId);
        data.put("employee_name",employee_name);
        data.put("employee_salary",employee_salary);
        data.put("employee_age",employee_age);
        data.put("profile_image",profile_image);


        JSONObject responseBody = new JSONObject();
        responseBody.put("status", status);
        responseBody.put("data", data);
        responseBody.put("message", message);



        return responseBody;
    }




}
