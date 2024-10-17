package tests;

import baseURL.BaseUrlCollectApi;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C42_CollectApi_PathQuery extends BaseUrlCollectApi {

    @Test
    public void test(){

        /*

    Given kullanici colllectApi adresine gider
    Then  kullanici path parametreleri olarak "economy/currencyToAll"kullanir
    Then  kullanici query parametrei olarak "int" olarak 1 "base" olarak "TRY" girer
    Then  kulanici donen cevabi kaydeder
    Then  kullanici donen cevabi yazdirir
         */

        //1 url request body

        specCollectApi
                .pathParams("pp1","economy","pp2","currencyToAll")
                .queryParam("qp1",1,"qp2","TRY");


        /*
        https://api.collectapi.com/economy/currencyToAll/1/TRY
        Path parametrelerinden sonra query parametreleri,
        URL'nin sonuna ? işareti ile eklenir ve bir anahtar-değer
        çifti olarak tanımlanır. Birden fazla query parametresi varsa,
        aralarına & işareti konur.

        https://baseURL/path/{pathParam} ?  queryParam1=value1  &  queryParam2=value2

         */
        // authorization: apikey 6VWHOGdI99V7nGIrbMid8X:4BuAtU4pPg0UQdJC80cbcc'

        Response response=given()
                .spec(specCollectApi)
                .when()
                .header("authorization", "apikey 6VWHOGdI99V7nGIrbMid8X:4BuAtU4pPg0UQdJC80cbcc")
                .get("{pp1}/{pp2}");

        response.prettyPrint();









    }
}
