package rest;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import framework.ReadPropertyValues;

public class LoginRequests {
	
	static Properties prop = ReadPropertyValues
			.getPropertyFile("./config/resources.properties");
	
	static String login = prop.getProperty("login")
			.replace("[server]", prop.getProperty("server"))
			.replace("[port]", prop.getProperty("port"));
	
	/**
	 * Method to get the token
	 * @throws UnsupportedOperationException
	 * @throws IOException
	 */
	public static String getToken() throws UnsupportedOperationException, IOException
	{
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpPost request = new HttpPost(login);
			
			request.addHeader("Content-type", "application/json");
			request.setHeader("Accept", "application/json");
			  
			JSONObject body=new JSONObject();
			body.put("username", prop.getProperty("username"));
			body.put("password", prop.getProperty("password"));
			body.put("authentication", prop.getProperty("authentication"));
			
			StringEntity entity = new StringEntity(body.toString());
		    request.setEntity(entity);
			
            HttpResponse result = httpClient.execute(request);
            
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            
            try {
                JSONParser parser = new JSONParser();
                Object resultObject = parser.parse(json);
                
                JSONObject obj =(JSONObject)resultObject;
//                System.out.println(obj.get("token"));
                return obj.get("token").toString();

            } catch (Exception e) {
                // TODO: handle exception
            }

        } catch (IOException ex) {
        }
		return null;
	}

}
