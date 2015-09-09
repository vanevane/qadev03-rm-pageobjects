package rest;

//import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import framework.ReadPropertyValues;

//import com.gargoylesoftware.htmlunit.util.NameValuePair;

import tests.EmailServersTest;

public class ResourcesRequests {
	static String token;
//	String resourceId;
	static Properties prop = ReadPropertyValues
			.getPropertyFile("./config/resources.properties");
	
	/**
	 * API endpoints
	 */
	static String login = prop.getProperty("login")
			.replace("[server]", prop.getProperty("server"))
			.replace("[port]", prop.getProperty("port"));
	static String resource = prop.getProperty("resources")
			.replace("[server]", prop.getProperty("server"))
			.replace("[port]", prop.getProperty("port"));
	static String resourceById = prop.getProperty("resourceById")
			.replace("[server]", prop.getProperty("server"))
			.replace("[port]", prop.getProperty("port"));
			
	
	/**
	 * Get all the resources
	 * @throws UnsupportedOperationException
	 * @throws IOException
	 */
	public static ArrayList<JSONObject> getResources() throws UnsupportedOperationException, IOException
	{
		ArrayList<JSONObject> listResponse = new ArrayList<JSONObject>();
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet request = new HttpGet(resource);
			
            request.setHeader("Content-type", "application/json");
            HttpResponse result = httpClient.execute(request);

            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            
            try {
                JSONParser parser = new JSONParser();
                Object resultObject = parser.parse(json);

                if (resultObject instanceof JSONArray) {
                    JSONArray array=(JSONArray)resultObject;
                    
                    for (Object object : array) {
                        JSONObject obj =(JSONObject)object;
                        listResponse.add(obj);
//                        System.out.println(obj.get("name"));
                    }

                }else if (resultObject instanceof JSONObject) {
                    JSONObject obj =(JSONObject)resultObject;                    
                    listResponse.add(obj);
                }
                return listResponse;

            } 
            catch (Exception e) {
                // TODO: handle exception
            }
        } 
		catch (IOException ex) {
        }
		return listResponse;
	}

	/**
	 * Create a resource
	 * @throws UnsupportedOperationException
	 * @throws IOException
	 */
	public static void postResource() throws UnsupportedOperationException, IOException
	{
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpPost request = new HttpPost(resource);
			
			token = LoginRequests.getToken();
			
			/**
			 * Setting the headers
			 */
			request.addHeader("Content-type", "application/json");
			request.setHeader("Accept", "application/json");
			request.setHeader("Authorization", "jwt "+ token);
			
			/**
			 * Request's body
			 */
			JSONObject body = new JSONObject();
		  	body.put("name", "gift");
		  	body.put("customName", "gift");
		  	body.put("fontIcon", "fa fa-gift");
		  	body.put("from", "");
		  	body.put("description", "");
		  	
			StringEntity entity = new StringEntity(body.toString());
		    request.setEntity(entity);

            HttpResponse result = httpClient.execute(request);

        } 
		catch (IOException ex) {
        }
	}
	
	public static void deleteResource(String resourceId) throws UnsupportedOperationException, IOException
	{
		String url = resourceById.replace("[resourceId]", resourceId);
		token = LoginRequests.getToken();
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpDelete request = new HttpDelete(url);

			request.setHeader("Content-type", "application/json");
            request.setHeader("Accept", "application/json");
			request.setHeader("Authorization", "jwt "+ token);

			HttpResponse result = httpClient.execute(request);

            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
        } 
		catch (IOException ex) {
        }
	}
	
	
//	/**
//	 * Method to get the token
//	 * @throws UnsupportedOperationException
//	 * @throws IOException
//	 */
//	public static void getToken() throws UnsupportedOperationException, IOException
//	{
//		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
//			HttpPost request = new HttpPost(login);
//			
//			request.addHeader("Content-type", "application/json");
//			request.setHeader("Accept", "application/json");
//			  
//			JSONObject body=new JSONObject();
//			body.put("username", prop.getProperty("username"));
//			body.put("password", prop.getProperty("password"));
//			body.put("authentication", prop.getProperty("authentication"));
//			
//			StringEntity entity = new StringEntity(body.toString());
//		    request.setEntity(entity);
//			
//            HttpResponse result = httpClient.execute(request);
//            
//            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
//            
//            try {
//                JSONParser parser = new JSONParser();
//                Object resultObject = parser.parse(json);
//                
//                JSONObject obj =(JSONObject)resultObject;
////                System.out.println(obj.get("token"));
//                res = obj.get("token").toString();
//
//            } catch (Exception e) {
//                // TODO: handle exception
//            }
//
//        } catch (IOException ex) {
//        }
//	}
	
	
	public static void main(String[] args) {
		ResourcesRequests req = new ResourcesRequests();
		
		try {
			req.getResources();
//			req.getToken();
//			req.postResource();
//			req.deleteResource();
		} catch (UnsupportedOperationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
