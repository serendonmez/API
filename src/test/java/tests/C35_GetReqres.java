package tests;

import baseURL.BaseUrlReqres;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C35_GetReqres extends BaseUrlReqres {



    /*
    Soru: ReqRes API'sini kullanarak,
    bir kullanıcının ID'sine göre bilgilerinin alındığı
    bir GET isteği yapmanız isteniyor.
    Aşağıdaki gereksinimleri karşılayan bir TestNG test sınıfı yazın:

        https://reqres.in/api/users/2 URL'sine bir GET isteği gönderin.

        Dönen cevabın aşağıdaki gibi olduğunu test edin
        {
            "data": {
                        "id": 2,
                        "email": "janet.weaver@reqres.in",
                        "first_name": "Janet",
                        "last_name": "Weaver",
                        "avatar": "https://reqres.in/img/faces/2-image.jpg"
                      },
           "support": {
                        "url": "https://reqres.in/#support-heading",
                        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
                      }
}

     */

    @Test
    public void test(){

        //1 url Request body hazirla


        specUrlReqres.pathParams("pp1","users","pp2",2);


        //2 expected Data hazirla

        JSONObject data=new JSONObject();

        data.put("id",2);
        data.put("email","janet.weaver@reqres.in");
        data.put("first_name","Janet");
        data.put("last_name","Weaver");
        data.put("avatar","https://reqres.in/img/faces/2-image.jpg");

        JSONObject support=new JSONObject();
        support.put("url","https://reqres.in/#support-heading");
        support.put("text","To keep ReqRes free, contributions towards server costs are appreciated!");

        JSONObject expectedData=new JSONObject();
        expectedData.put("data",data);
        expectedData.put("support",support);

        // 3 Req gönder Response kqydet

        Response response=given().contentType(ContentType.JSON).spec(specUrlReqres)
                                .when()
                                .get("/{pp1}/{pp2}");


        //4 assertion
        JsonPath responseJP=response.jsonPath();
        Assert.assertEquals(expectedData.getJSONObject("data").get("id"),responseJP.get("data.id"));
        Assert.assertEquals(expectedData.getJSONObject("data").getString("email"),responseJP.get("data.email"));
        Assert.assertEquals(expectedData.getJSONObject("data").getString("first_name"),responseJP.get("data.first_name"));
        Assert.assertEquals(expectedData.getJSONObject("data").getString("last_name"),responseJP.get("data.last_name"));
        Assert.assertEquals(expectedData.getJSONObject("data").getString("avatar"),responseJP.get("data.avatar"));
        Assert.assertEquals(expectedData.getJSONObject("support").getString("url"),responseJP.get("support.url"));
        Assert.assertEquals(expectedData.getJSONObject("support").getString("text"),responseJP.get("support.text"));







    }




}
