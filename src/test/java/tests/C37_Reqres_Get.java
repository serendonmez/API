package tests;

import baseURL.BaseUrlReqres;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C37_Reqres_Get extends BaseUrlReqres {

    /*
        https://reqres.in/api/users?page=2 URL’sine bir GET isteği gönderin.
    Gelen yanıtın durum kodunun 200 olduğunu doğrulayın.
    Liste içerisindeki kullanıcı sayısının en az 1 olduğunu doğrulayın.
    İlk kullanıcının email adresinin boş olmadığını kontrol edin.
         */

    @Test
    public void test(){

        //1
        String url="https://reqres.in/api/users?page=2";

        //2 expected data
        //3 Response

        Response response=given().spec(specUrlReqres).when().get(url);

        response.prettyPrint();
        //4 Assertion


       response.then().assertThat().statusCode(200);

        JsonPath responseJP=response.jsonPath();
        int userCount= responseJP.getList("data").size();
        Assert.assertTrue(userCount>0);

        String firstEmail=responseJP.getString("data[0].email");
        Assert.assertFalse(firstEmail.isEmpty());










    }
}
