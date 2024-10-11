package tests;

import baseURL.BaseURlDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceHolder;
import testDatalari.TestDatalariDummy;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C26_Get_TestDataKullanimi extends BaseURlDummy{
    /*
    http://dummy.restapiexample.com/api/v1/employee/3  url’ine bir GET request gonderdigimizde
    donen response’un status code’unun 200,
    content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
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

    @Test
    public void test(){

        // 1- Url and Request

        specBaseUrlDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        // 2 Expected data

        JSONObject expectedData= TestDatalariDummy.responseBodyOlustur("success",3, "Ashton Cox",
               86000, 66,"","Successfully! Record has been fetched.");





        // 3 Req gönder Response kaydet

        Response response=given().when().spec(specBaseUrlDummy).get("/{pp1}/{pp2}/{pp3}/{pp4}");


        JsonPath jsonPathResponse= response.jsonPath();


        // Assertion


        assertEquals(TestDatalariDummy.statusCode, response.statusCode());
        assertEquals(TestDatalariDummy.contentType, response.contentType());
        assertEquals(expectedData.getJSONObject("data")
                .getString("employee_name"),
                jsonPathResponse.getString("data.employee_name"));

        assertEquals(expectedData.getJSONObject("data").getInt("id"), jsonPathResponse.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"), jsonPathResponse.getInt("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"),jsonPathResponse.getInt("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").getString("profile_image"), jsonPathResponse.getString("data.profile_image"));
        assertEquals(expectedData.getString("message"), jsonPathResponse.getString("message"));
        assertEquals(expectedData.getString("status"), jsonPathResponse.getString("status"));

    }



}
