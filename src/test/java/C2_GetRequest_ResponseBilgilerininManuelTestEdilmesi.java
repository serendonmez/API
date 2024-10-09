import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C2_GetRequest_ResponseBilgilerininManuelTestEdilmesi {


    @Test
    public void test01(){
        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
  status code’unun 200,
 ve content type’inin application/json; charset=utf-8,
 ve Server isimli Header’in degerinin Cowboy,
 ve status Line’in HTTP/1.1 200 OK
 ve resonse suresinin 5 sn den kisa oldugunu test edin
         */


        // 1- Request body ve end point hazirlama
        String url= "https://restful-booker.herokuapp.com/booking/10";

        //2- Expected data hazirlama

        //3- Request gönderip, dönen response i kaydetme
        Response response= given().when().get(url);


        // response in bodysini sadece response.prettyPrint(); ile yazdirabiliriz
        // System.out.println(response.getBody().toString()); bize ref point verir.


        System.out.println("Status Code: "+ response.getStatusCode());
        System.out.println("Content Type: "+ response.contentType());
        System.out.println("Header (Server): "+ response.header("Server"));
        System.out.println("Status Line: "+ response.statusLine());
        System.out.println("Response Time: "+ response.time());


    }
}
