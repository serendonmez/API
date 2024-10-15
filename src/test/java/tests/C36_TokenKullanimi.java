package tests;

import baseURL.BaseUrlHeroKuApp;
import baseURL.BaseUrlReqres;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatalari.TestDatalariHeroKu;

import static io.restassured.RestAssured.given;

public class C36_TokenKullanimi extends BaseUrlHeroKuApp {


     /*
    https://restful-booker.herokuapp.com/booking/2410 (id güncellenmeli)
    adresindeki rezervasyon bilgilerini
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
        header değerleriyle PUT request göndererek update ediniz.


        Token Oluşturma
        Content-Type: application/json header derğeriyle aşağıdaki body ile
        {
                "username" : "admin",
                "password" : "password123"
        }
        Post Request yapınız

 */
    static String token;

    @Test
    public  void tokenCreate(){



        // 1
        specHeroKuApp.pathParam("pp1","auth");

        // 2 req TokenBody:

        JSONObject tokenBody=new JSONObject();
        tokenBody.put("username","admin");
        tokenBody.put("password","password123");


        //3
        Response response=given().spec(specHeroKuApp)
                                                        .contentType(ContentType.JSON)
                                                        .when()
                                                        .body(tokenBody.toString())
                                                        .header("Content-Type","application/json")
                                                        .post("/{pp1}");

        JsonPath responseJP=response.jsonPath();
        token=responseJP.getString("token");



    }


    @Test
    public void test(){

        specHeroKuApp.pathParams("pp1","booking","pp2",2410);

        JSONObject booking=TestDatalariHeroKu.responseBodyOlustur("Jason","Smith",225,
                true,"2024-01-26","2024-02-14","wifi");



        Response response=given().spec(specHeroKuApp).contentType(ContentType.JSON)
                .when().body(booking.toString()).header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Cookie","token="+token)
                .put("/{pp1}/{pp2}");





    }

    // Token olmadan Authorization ile test:

    @Test
    public void testWithAuthorization(){

        specHeroKuApp.pathParams("pp1","booking","pp2",2410);

        JSONObject booking=TestDatalariHeroKu.responseBodyOlustur("Jason","Smith",225,
                true,"2024-01-26","2024-02-14","wifi");

        Response response=given().spec(specHeroKuApp).contentType(ContentType.JSON)
                .when().body(booking.toString()).header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .put("/{pp1}/{pp2}");








    }

}
