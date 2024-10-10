import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdirma {

    @Test
    public void get01(){
        // https://restful-booker.herokuapp.com/booking/10 url ine
        // bir GET request gonderdigimizde dönen response i yazdirin



        // 1- Request body ve end point hazirlama
        String url= "https://restful-booker.herokuapp.com/booking/10";

        //2- Expected data hazirlama

        //3- Request gönderip, dönen response i kaydetme
        Response response= given().when().get(url);
        response.prettyPrint();
        //4- Assertion

        System.out.println("Status Code: "+ response.getStatusCode());
        System.out.println("Content Type: "+ response.contentType());
        System.out.println("Header (Server): "+ response.header("Server"));
        System.out.println("Status Line: "+ response.statusLine());
        System.out.println("Response Time: "+ response.time());



    }
}
