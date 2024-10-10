import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_SoftAssertIleExpectedDataTesti {
    @Test
    public void test(){

        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
        gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
            Response Body
                {
                    "status":"success",
                    "data":{
                            "id":3,
                            "employee_name":"Ashton Cox",
                            "employee_salary":86000,
                            "employee_age":66,
                            "profile_image":""
                            },
                    "message":"Successfully!Record has been fetched."
                }
         */


        //1
        String url="http://dummy.restapiexample.com/api/v1/employee/3";



        // 2

        JSONObject data=new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expectedData= new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",data);
        expectedData.put("message","Successfully!Record has been fetched.");
        System.out.println(expectedData);

        //3
        Response response= given().when().get(url);




        //4
        SoftAssert softAssert=new SoftAssert();

        // response üzerindeki bilgileri kolay almak icin
        // json path e cast ederiz

        JsonPath responseJsonPath= response.jsonPath();


        // Junit->   ( expected, actual)
        // test NG (actual, expected)


        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.id"),expectedData.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),expectedData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),expectedData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),expectedData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonPath.get("data.profile_image"),expectedData.getJSONObject("data").get("profile_image"));



        softAssert.assertAll();


    }
}
