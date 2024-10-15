package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.pojosOpenWeather.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C34_Post_Pojo {

    /*
    https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0
    url’ine bir post request gonderdigimizde donen response’un asagidaki
    body’ye sahip oldugunu test ediniz



  {

        "coord": {
                  "lon": -0.1257,
                  "lat": 51.5085
                  },
        "weather": [
                      {
                        "id": 804,
                        "main": "Clouds",
                        "description": "overcast clouds",
                        "icon": "04d"
                      }
                   ],
        "base": "stations",
        "main": {
                      "temp": 284.47,
                      "feels_like": 284.01,
                      "temp_min": 283.53,
                      "temp_max": 285.51,
                      "pressure": 1016,
                      "humidity": 90,
                      "sea_level": 1016,
                      "grnd_level": 1012
                 },
        "visibility": 10000,
        "wind":
                {
                  "speed": 5.14,
                  "deg": 70
                },
        "clouds":
                    {
                    "all": 100
                      },
        "dt": 1728923708,
        "sys":
                   {
                      "type": 2,
                      "id": 2075535,
                      "country": "GB",
                      "sunrise": 1728886985,
                      "sunset": 1728925766
                    },
        "timezone": 3600,
        "id": 2643743,
        "name": "London",
        "cod": 200
  }





     */


    @Test
    public void test(){
        //1

        String url="https://api.openweathermap.org/data/2.5/weather?q=London&appid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0";

        //2 expectedData olustur

        Clouds clouds=new Clouds(100);
        Coord coord=new Coord((float) -0.1257, 51.5085F);
        Main main=new Main(284.47F, 284.01F, 283.53F, 285.51F,1016,90,1016,1012);

        Sys sys=new Sys(2,2075535,"GB",1728886985,1728925766);

        List<Weather> weatherList=new ArrayList<>();

        Weather weatherPojo=new Weather(804,"Clouds","overcast clouds","04d");
        weatherList.add(weatherPojo);
        Wind wind=new Wind(5.14F,70);


        PojoOWeather expectedDataPojoOWeather=new PojoOWeather(coord, (List<Weather>) weatherList,"stations",main,10000,
                wind,clouds,1728923708,sys,3600,2643743,"London",200);


        //3 response save

        Response response= given().when().post(url);


        // Assertion

        // expectedData (PojoOWeather)  <--------> response (Response)

        PojoOWeather responsePojo=response.as(PojoOWeather.class);

        // response i Pojo ya cevirdigimizde tüm bilgileri getirirse
        // responsePojo yu assertion da kullanabiliriz
        // Eger null deger dönerse response i JsonPath e cast edip
        // kullaniriz
       // System.out.println(responsePojo);

        /*
        pojos.pojosOpenWeather.PojoOWeather@3491e86e
        [
        coord=pojos.pojosOpenWeather.Coord@68f32020 [lon=-0.1257,lat=51.5085],
        weather= [pojos.pojosOpenWeather.Weather@19b047fe [id=701,main=Mist,description=mist,icon=50d]], base=stations,
        main=pojos.pojosOpenWeather.Main@22590e3e [temp=284.78,feelsLike=<null>,tempMin=<null>,tempMax=<null>,pressure=1016,humidity=93,seaLevel=<null>,grndLevel=<null>],visibility=3100,
        wind=pojos.pojosOpenWeather.Wind@53dad875[speed=3.09,deg=90],
        clouds=pojos.pojosOpenWeather.Clouds@5f780a86[all=100],dt=1728978249,
        sys=pojos.pojosOpenWeather.Sys@446c3920[type=2,id=2075535,country=GB,sunrise=1728973487,sunset=1729012037],timezone=3600,id=2643743,name=London,cod=200]
         */

        JsonPath responseJP =response.jsonPath();
        // expectedData (PojoOWeather)  <--------> response (JsonPath)

       assertEquals(expectedDataPojoOWeather.getCoord().getLon(),responseJP.get("coord.lon"));
       assertEquals(expectedDataPojoOWeather.getCoord().getLat(),responseJP.get("coord.lat"));
       assertEquals(expectedDataPojoOWeather.getBase(),responseJP.get("base"));
       assertEquals(expectedDataPojoOWeather.getSys().getCountry(),responseJP.get("sys.country"));





    }
}
