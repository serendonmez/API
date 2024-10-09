import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_GetBody_TekrarlardanKurtulma {

    @Test
    public void test(){


      /*
      https://restful-booker.herokuapp.com/booking/10  url’ine bir GET request gonderdigimizde
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki"firstname“in,"Eric",
            ve "lastname“in, "Smith",
            ve "totalprice“in 1000 den az oldugunu,
            ve "depositpaid“in,true,
            ve "additionalneeds“in,bos olmadigini
             test edin
       */



        //1- End point

        String url= "https://restful-booker.herokuapp.com/booking/10";

        //2 - Expected Response

        //3- send Request , Save Response
        Response response= given().when().get(url);
      // response.prettyPrint();

     //4 Assert
        /*
        response.then().assertThat()
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Eric"))
                .body("lastname", Matchers.equalTo("Smith"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid", Matchers.equalTo(true))
                .body("additionalneeds", Matchers.notNullValue());

                        */

        // 2. yöntem

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Eric"),
                        "lastname", equalTo("Smith"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(true),
                        "additionalneeds", notNullValue());


    }
}
