package encora.apiclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;

public class ClientAPI {

    public void get(String url) throws IOException {
        CloseableHttpClient httpClient=HttpClients.createDefault();
        HttpGet httpget=new HttpGet(url);
        CloseableHttpResponse response=httpClient.execute(httpget);
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("Status Code is "+statusCode);

        //Response JSON String
        String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
        JSONObject responseJson=new JSONObject(responseString);
        System.out.println(responseJson.get("list"));
        JSONArray jsonArray = (JSONArray) responseJson.get("list");
        for(int i=0;i<1;i++){
            JSONObject jsonObj1 = (JSONObject)jsonArray.get(1);
            JSONObject jsonObj2 = (JSONObject)jsonObj1.get("main");
            System.out.println(jsonObj2.get("temp"));
            int temp=getTempInCel(jsonObj2.get("temp").toString());
            System.out.println("Temperature is : "+temp);
        }
    }

    public int getTempInCel(String tempInKelvin){
        double c=Double.valueOf(tempInKelvin)-273.15;
        return(int)c;
    }
}
