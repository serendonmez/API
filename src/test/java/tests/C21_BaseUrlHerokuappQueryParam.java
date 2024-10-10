package tests;

import baseURL.BaseUrlHeroKuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHeroKuApp {


    /*
            1-  https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak
            “firstname” degeri “Susan” olan rezervasyon oldugunu
            test edecek bir GET request gonderdigimizde,
            donen response’un status code’unun 200 oldugunu
            ve “Eric” ismine sahip en az bir booking oldugunu test edin


            2- https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak
             “firstname” degeri “Jim”
             ve “lastname” degeri “Jackson” olan rezervasyon oldugunu
             test edecek bir GET request gonderdigimizde,
             donen response’un status code’unun 200 oldugunu
             ve “Jim Jackson” ismine sahip en az bir booking oldugunu test edin

     */

    @Test
    public void test1(){
        /*
         1-  https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak
            “firstname” degeri “Eric” olan rezervasyon oldugunu
            test edecek bir GET request gonderdigimizde,
            donen response’un status code’unun 200 oldugunu
            ve “Susan” ismine sahip en az bir booking degerinin 2 oldugunu test edin
         */

        //1 endpoint ve request body hazirla

        specHeroKuApp.pathParam("pp1","booking")
                .queryParam("firstname","Susan");


        //2 expected data olustur

        //3 request gönder dönen response i kaydet
        Response response=given().when().spec(specHeroKuApp)
                .get("/{pp1}");


        response.prettyPrint();

        // 4- Assert

        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(2));



    }


    @Test
    public void test2(){

        /*
         2- https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak
             “firstname” degeri “Eric”
             ve “lastname” degeri “Brown”
             olan rezervasyon oldugunu
             test edecek bir GET request gonderdigimizde,
             donen response’un status code’unun 200 oldugunu
             ve “Jim Jackson” ismine sahip en az bir booking oldugunu test edin
         */

        //1 Request body ve end point hazirla

        specHeroKuApp.pathParam("pp1","booking")
                .queryParams("firstname","Eric","lastname","Brown");

        //2 expected data hazirla

        //3 Request gönder Response kaydet
        Response response = given().when().spec(specHeroKuApp).get("/{pp1}");
        response.prettyPrint();

        // assertion
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(1));




    }
}
