
import org.json.JSONObject;
import org.junit.Test;

public class C04_Generate_JSON_Object {


    /*
    JSON objesini konsolda yazdirin

        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
        }

     */
    @Test
    public void test(){

    JSONObject data=new JSONObject();
    data.put("title","Ahmet");
    data.put("body","Merhaba");
    data.put("userId",1);
    System.out.println(data);



}



}
