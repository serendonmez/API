package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.replaceFiltersWith;

public class C16_Put_SoftAssertIleExpectedDataTesti {

    @Test
    public void Test(){
        /*
        http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
        request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
            Request Body
            {
                "status":"success",
                "data":
                    {
                        "name":“Ahmet",
                        "salary":"1230",
                        "age":"44",
                        "id":40
                     }
            }


            Response Body
                {
                    "status":"success",
                    "data": {
                        "status":"success",
                        "data":{
                                "name":“Ahmet",
                                "salary":"1230",
                                "age":"44",
                                "id":40}
                    },
                    "message":"Successfully!Record has been updated."
                }
         */

        //1

        String url= "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestDataBilgileri=new JSONObject();
        requestDataBilgileri.put("name","Ahmet");
        requestDataBilgileri.put("salary","1230");
        requestDataBilgileri.put("age","44");
        requestDataBilgileri.put("id",40);

        JSONObject requestBody=new JSONObject();
        requestBody.put("status","success");
        requestBody.put("data",requestDataBilgileri);


        //2

        JSONObject expectedData=new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Successfully!Record has been updated.");

        //3
        Response response= given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

        // 4

        JsonPath jsonPathresponse= response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        // (actual, expected)

        softAssert.assertEquals(jsonPathresponse.get("status"),expectedData.get("status"));
        softAssert.assertEquals((jsonPathresponse.get("message")),expectedData.get("message"));
        softAssert.assertEquals(jsonPathresponse.get("data.status"),expectedData.getJSONObject("data").get("status"));
        softAssert.assertEquals(jsonPathresponse.get("data.data.name"),expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(jsonPathresponse.get("data.data.salary"),expectedData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(jsonPathresponse.get("data.data.age"),expectedData.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertEquals(jsonPathresponse.get("data.data.id"),expectedData.getJSONObject("data").getJSONObject("data").get("id"));

        softAssert.assertAll();




    }
}
