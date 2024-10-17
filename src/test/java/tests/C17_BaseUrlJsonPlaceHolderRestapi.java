package tests;

import baseURL.BaseUrlHeroKuApp;
import baseURL.BaseUrlJsonPlaceHolderAPI;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlJsonPlaceHolderRestapi extends BaseUrlJsonPlaceHolderAPI {
/*
        Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
        1-  https://jsonplaceholder.typicode.com/posts        endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test
        edin
        2-  https://jsonplaceholder.typicode.com/posts/44
        endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve “title” degerinin
        “optio        dolor        molestias
        sit” oldugunu test edin
        3-  https://jsonplaceholder.typicode.com/posts/50
        endpointine bir DELETE request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
        null oldugunu test edin
 */

    @Test
    public void test1(){
        /*
         1-  https://jsonplaceholder.typicode.com/posts        endpointine
         bir GET request gonderdigimizde donen response’un status code’unun 200 oldugunu
         ve Response’ta 100 kayit oldugunu test edin
         */
        //1 Endpoint ve request body olustur

        specPlaceHolder.pathParam("pp1","posts");

        //2 Expected data

        //3 Request gönder Dönen Response i kaydet

        Response response=given().when().spec(specPlaceHolder).get("/{pp1}");
       // response.prettyPrint();

        //4

        response.then().assertThat().statusCode(200).body("id", Matchers.hasSize(100));





    }

    @Test
    public void test2(){

        /*
        2-  https://jsonplaceholder.typicode.com/posts/44
        endpointine bir GET request gonderdigimizde
        donen response’un status code’unun 200 oldugunu ve “title” degerinin
        “optio        dolor        molestias
        sit” oldugunu test edin
         */

        //1 generate Request body and end point
        specPlaceHolder.pathParams("pp1","posts","pp2","44");





        //2 generate Expected Data

        //3 send Request save Response
        Response response=given().when().spec(specPlaceHolder).get("/{pp1}/{pp2}");
        //response.prettyPrint();


        // 4 assert
            response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));





    }


    @Test
    public void test3(){

        /*
        3-  https://jsonplaceholder.typicode.com/posts/50
        endpointine bir DELETE request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve response body’sinin
        null oldugunu test edin
         */


        //1
        specPlaceHolder.pathParams("pp1","posts","pp2",50);
        //2

        //3
        Response response=given().when().spec(specPlaceHolder).delete("/{pp1}/{pp2}");
       // response.prettyPrint();

        //4

        response.then().assertThat().statusCode(200).body(Matchers.equalTo("{}"));






    }







}
