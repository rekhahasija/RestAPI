package encora.tests;

import encora.apiclient.ClientAPI;
import encora.base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetAPITest extends TestBase {
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

    @Test
    public void getAPITest() throws IOException {
        client=new ClientAPI();
        client.get(actualUrl);
    }

}
