package rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import tests.EmailServersTest;

public class ResourcesRequests {
	
	public void getResources() throws UnsupportedOperationException, IOException
	{
		String url = "http://172.20.208.79:4040/resources";
		
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet request = new HttpGet(url);
//            StringEntity params = new StringEntity(body);
            request.addHeader("content-type", "application/json");
//            request.setEntity(params);
            HttpResponse result = httpClient.execute(request);

            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            try {
                JSONParser parser = new JSONParser();
                Object resultObject = parser.parse(json);

                if (resultObject instanceof JSONArray) {
                    JSONArray array=(JSONArray)resultObject;
                    for (Object object : array) {
                        JSONObject obj =(JSONObject)object;
                        System.out.println(obj.get("name"));
                        System.out.println(obj.get("_id"));
//                        System.out.println(obj.get("example"));
//                        System.out.println(obj.get("fr"));
                    }

                }else if (resultObject instanceof JSONObject) {
                    JSONObject obj =(JSONObject)resultObject;
                    System.out.println(obj.get("name"));
                    System.out.println(obj.get("name"));
//                    System.out.println(obj.get("example"));
//                    System.out.println(obj.get("fr"));
                }

            } catch (Exception e) {
                // TODO: handle exception
            }

        } catch (IOException ex) {
        }
//        return null;
    
		
		
		
		
		
		

//		HttpClient client = HttpClientBuilder.create().build();
//		HttpGet request = new HttpGet(url);
		
		

		// add request header
//		request.addHeader("User-Agent", USER_AGENT);
//		request.addHeader("Content-Type", "application/json");
//		HttpResponse response = client.execute(request);
////				ResponseHandler<String> handler = new BasicResponseHandler();
////		        System.out.println(handler.handleResponse(response));
////
//		System.out.println("Response Code : " 
//	                + response.getStatusLine().getStatusCode());
//
//		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//
//		StringBuffer result = new StringBuffer();
//		String line = "";
//		while ((line = rd.readLine()) != null) {
//		    result.append(line);
//		}
//		String json = EntityUtils.toString(response.getEntity(), "UTF-8");
//
//		JSONObject k = new jso
//		JSONObject o = new JSONObject(json);
		
		
//		
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpGet httpget = new HttpGet("http://172.20.208.79:4040/resources");
//		CloseableHttpResponse response = httpclient.execute(httpget);
//		try {
//			HttpEntity entity = response.getEntity();
//			if (entity != null) {
//			long len = entity.getContentLength();
//			if (len != -1 && len < 2048) {
//		
//			System.out.println(EntityUtils.toString(entity));
//			} else {
//			// Stream content out
//			}
//			}
//			} finally {
//			response.close();
//			}
		
		
		
//		String res = Request.Get("http://172.20.208.79:4040/resources")
//        .connectTimeout(1000)
//        .socketTimeout(1000)
//        .execute().returnContent().asString();
//		System.out.println(res);
	}

	
	public static void main(String[] args) {
		ResourcesRequests req = new ResourcesRequests();
		
		try {
			req.getResources();
		} catch (UnsupportedOperationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
