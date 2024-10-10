package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_ResponseBodyTesti {

    @Test
    public void test(){

       /*
       https://jsonplaceholder.typicode.com/posts  url’ine asagidaki body ile bir POST request
        gonderdigimizde
        {
        "title":"API",
        "body":"API ogrenmek ne guzel",
        "userId":10
        }

        donen Response’un,

        status code’unun 201,
        ve content type’inin application/json
        ve Response Body'sindeki,
        "title"'in "API" oldugunu
        "userId" degerinin 100'den kucuk oldugunu
        "body" nin "API" kelimesi icerdigini
        test edin.
        */



        //1 End point request body hazirla

        String url= "https://jsonplaceholder.typicode.com/posts";

        JSONObject obje=new JSONObject();
        obje.put("title","API");
        obje.put("body","API ogrenmek ne guzel");
        obje.put("userId",10);



        //2 Expected data hazirla


        //3 Request gönder Response i kaydet
        Response response= given().contentType(ContentType.JSON)
                .when().body(obje.toString())
                .post(url);

        response.prettyPrint();

        // 4 assertion
            response
                    .then()
                    .assertThat()
                    .statusCode(201)
                    .contentType(ContentType.JSON)
                    .body("title", Matchers.equalTo("API"))
                    .body("userId", Matchers.lessThan(100))
                    .body("body", Matchers.containsString("API"));

    }
}
