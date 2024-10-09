import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C10_JSONPathKullanimi {

    @Test
    public void test(){
        JSONObject kisiBilgileriJSONObj=new JSONObject();
        JSONObject adresJSONObj=new JSONObject();

        JSONArray telefonBilgileriArr=new JSONArray();
        JSONObject cepTelJsonObj=new JSONObject();
        JSONObject evTelJsonObj=new JSONObject();


        adresJSONObj.put("streetAddress","naist street");
        adresJSONObj.put("city","Nara");
        adresJSONObj.put("postalCode","630-0192");

        cepTelJsonObj.put("type","iPhone");
        cepTelJsonObj.put("number","0123-456-8888");

        evTelJsonObj.put("type","home");
        evTelJsonObj.put("number","0123-4567-8910");
        telefonBilgileriArr.put(cepTelJsonObj);
        telefonBilgileriArr.put(evTelJsonObj);

        kisiBilgileriJSONObj.put("firstname","John");
        kisiBilgileriJSONObj.put("lastname","doe");
        kisiBilgileriJSONObj.put("age",26);
        kisiBilgileriJSONObj.put("address",adresJSONObj);
        kisiBilgileriJSONObj.put("phoneNumbers",telefonBilgileriArr);

        System.out.println(kisiBilgileriJSONObj);

        // iphone number i yazdir


        System.out.println("firstname : "+kisiBilgileriJSONObj.get("firstname"));

        System.out.println("streetAddress: "+ kisiBilgileriJSONObj.getJSONObject("address").get("streetAddress"));


        System.out.println("iphone number: "+ kisiBilgileriJSONObj.getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("number"));


            // phone numberstan home number i yazdir

        System.out.println("home number: "+kisiBilgileriJSONObj.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));



    }
}
