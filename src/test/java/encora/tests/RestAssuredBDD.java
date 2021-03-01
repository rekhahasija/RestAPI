package encora.tests;


import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import encora.base.TestBase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class RestAssuredBDD extends TestBase {
    TestBase testBase;
    String url;
    String serviceUrl;
    String actualUrl;
    public static Response response;
    public static String jsonAsString;

    @BeforeMethod
    public void setUp(){
        testBase=new TestBase();
        url=prop.getProperty("url");
        serviceUrl=prop.getProperty("serviceUrl");
        actualUrl=url+serviceUrl;
        System.out.println(actualUrl);

    }

    @Test
    public void firstTest(){
        given().
                when().
                get(actualUrl).
                then().
                assertThat().
                body("list.dt_txt",hasSize(40));
    }

    @Test
    public void tempTest(){
        //Gives temperature of all six days - all temperature recorded in 6 says
        response = given().
                when().
                get(actualUrl).
                then().
                contentType(ContentType.JSON).
                extract().response();
        jsonAsString = response.asString();
        JSONObject responseJson=new JSONObject(jsonAsString);
        System.out.println(responseJson.get("list"));
        JSONArray jsonArray = (JSONArray) responseJson.get("list");
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObj1 = (JSONObject)jsonArray.get(i);
            JSONObject jsonObj2 = (JSONObject)jsonObj1.get("main");
            int temp=getTempInCel(jsonObj2.get("temp").toString());
            //System.out.println("Temperature is : "+temp);
            if(temp>20){
                System.out.println("Use Swimmers");
            }else if(temp<20){
                System.out.println("Use Winter wear!!");
            }
        }
    }

    public int getTempInCel(String tempInKelvin){
        double c=Double.valueOf(tempInKelvin)-273.15;
        return(int)c;
    }

}
