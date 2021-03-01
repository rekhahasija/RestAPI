package encora.tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.Response;
import encora.apiclient.ClientAPI;
import encora.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredAPI extends TestBase {
    TestBase testBase;
    String url;
    String serviceUrl;
    String actualUrl;
    ClientAPI client;
    @BeforeMethod
    public void setUp() throws IOException {
        testBase=new TestBase();
        url=prop.getProperty("url");
        serviceUrl=prop.getProperty("serviceUrl");
        actualUrl=url+serviceUrl;
        System.out.println(actualUrl);

    }

    public Response doGetRequest(String endpoint) {
            RestAssured.defaultParser = Parser.JSON;
            return
                    given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                            when().get(endpoint).
                            then().contentType(ContentType.JSON).extract().response();
        }

        @Test
        public void getTest() {
            Response response = doGetRequest(actualUrl);
            List<String> jsonResponse = response.jsonPath().getList("$");
            System.out.println(jsonResponse.size());
        }
    }

