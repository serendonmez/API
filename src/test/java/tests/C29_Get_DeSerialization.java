package tests;

import baseURL.BaseURlDummy;
import io.restassured.response.Response;
import org.junit.Test;
import testDatalari.TestDatalariDummy;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C29_Get_DeSerialization extends BaseURlDummy {

    @Test
    public void test(){

        /*
        http://dummy.restapiexample.com/api/v1/employee/3
        url’ine bir GET request
        gonderdigimizde donen response’un status code’unun 200, content Type’inin
        application/json
        ve body’sinin asagidaki gibi oldugunu test edin.


        Response Body
        {
                "status":"success",
                "data":
                        {"id":3,
                        "employee_name":"Ashton Cox",
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                 "message":"Successfully! Record has been fetched."
         }




         */


        //1
        specBaseUrlDummy.pathParams("pp1","employee","pp2",3);

        //2 expected Body

        Map<String , Object> expectedDataMap= TestDatalariDummy.responseBodyOlustur2("success",3,"Ashton Cox",

                86000,66,"","Successfully! Record has been fetched.");

        // 3 req send response save

        Response response=given().spec(specBaseUrlDummy)
                .when().get("/{pp1}/{pp2}");


        //4 Assertion

        // expectedData ----     Response
        // Map  --------------Response



        Map<String, Object> resonseMap= response.as(HashMap.class);

        assertEquals(expectedDataMap.get("status"), resonseMap.get("status"));
        assertEquals(((Map)expectedDataMap.get("data")).get("id"), (((Map)resonseMap.get("data")).get("id")));
        assertEquals((((Map<?, ?>) expectedDataMap.get("data")).get("employee_name")), ((Map)resonseMap.get("data")).get("employee_name"));
        assertEquals((((Map<?, ?>) expectedDataMap.get("data")).get("employee_salary")), ((Map<?, ?>) resonseMap.get("data")).get("employee_salary"));
        assertEquals(((Map<?, ?>) expectedDataMap.get("data")).get("employee_age"), ((Map<?, ?>) resonseMap.get("data")).get("employee_age"));
        assertEquals(((Map<?, ?>) expectedDataMap.get("data")).get("profile_image"), ((Map<?, ?>) resonseMap.get("data")).get("profile_image"));
        assertEquals(expectedDataMap.get("message"), resonseMap.get("message"));











    }
}
