package tests;

import baseURL.BaseURlDummy;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoDummyResponsBodyData;
import pojos.PojoDummyResponseBody;
import testDatalari.TestDatalariDummy;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C33_Get_Pojo extends BaseURlDummy {


    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
     bir GET request gonderdigimizde donen response’un
      asagidaki gibi oldugunu test edin.

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

        //1- url ve Req body hazirlik

        specBaseUrlDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);



        // 2- expected Data
        PojoDummyResponsBodyData data=new
                PojoDummyResponsBodyData(3,"Ashton Cox",86000,66,"");


        PojoDummyResponseBody expectedData= new PojoDummyResponseBody("success",data,"Successfully! Record has been fetched.");

        //

        //3 Res kaydet
        Response response =given().spec(specBaseUrlDummy)
                                .when()
                                .get("/{pp1}/{pp2}/{pp3}/{pp4}");


        // 4 Assertion

        // expectedData(PojoDummyResponseBody) <-------> response (Response)

        // pojo yu otomatik olarak olusturursak (https://www.jsonschema2pojo.org/)
        // attribute isimlerini otomatik kendi
        //isimlendirdigi icin Responsei Pojo ya Convert edemiyoruz.
        // Bu durumda Response i JsonPath e cevirebiliriz

        // expectedData (Pojo) <----->  response (JsonPath)

        JsonPath responsePojo=response.jsonPath();



        assertEquals(TestDatalariDummy.statusCode,response.statusCode());



        assertEquals(expectedData.getStatus(),responsePojo.getString("status"));
        assertEquals(expectedData.getData().getId(),responsePojo.get("data.id"));
        assertEquals(expectedData.getData().getEmployeeName(),responsePojo.get("data.employee_name"));
        assertEquals(expectedData.getData().getEmployeeAge(),responsePojo.get("data.employee_age"));
        assertEquals(expectedData.getData().getEmployeeSalary(),responsePojo.get("data.employee_salary"));
        assertEquals(expectedData.getData().getProfileImage(),responsePojo.get("data.profile_image"));
        assertEquals(expectedData.getMessage(),responsePojo.getString("message"));










    }




}
