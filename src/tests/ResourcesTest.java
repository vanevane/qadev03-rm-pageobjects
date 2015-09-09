package tests;

import framework.ReadPropertyValues;
import framework.StartTest;
import framework.browser.BrowserManager;
import rest.ResourcesRequests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class ResourcesTest {
	Properties prop = ReadPropertyValues
			.getPropertyFile("./config/resources.properties");
	String username = prop.getProperty("username");
	String password = prop.getProperty("password");

	@Test
	public void CreateResource()
	{
//		String username = "rmdom2008\\room.manager";
//		String password = "M@nager";
		String name = "newResource";
		String displayName = "newResource";
		String id = "";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectResourcesOption()
		.AddResource()
		.setName(name)
		.setDisplayName(displayName)
		.Save();
//		.VerifyResourceWasCreated(name, displayName);

		//Postconditions
		try {
			ArrayList<JSONObject> resources = ResourcesRequests.getResources();
			for (JSONObject object : resources) {
				if(object.get("name").toString().equals(name))
					id = object.get("_id").toString();
			}
			ResourcesRequests.deleteResource(id);
			BrowserManager.getInstance().getBrowser().quit();
		
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void UpdateResourceName()
	{
		//Preconditions
		
		try {
			ResourcesRequests.postResource();
		
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}

		String name = "newResourceEdit";
		String id = "";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectResourcesOption()
		.UpdateResource()
		.setName(name)
		.Save()
		.VerifyResourceNameWasUpdated(name);
		
//		Postconditions
		try {
			ArrayList<JSONObject> resources = ResourcesRequests.getResources();
			for (JSONObject object : resources) {
				if(object.get("name").toString().equals(name))
					id = object.get("_id").toString();
			}
			ResourcesRequests.deleteResource(id);
			BrowserManager.getInstance().getBrowser().quit();
		
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
		
		BrowserManager.getInstance().getBrowser().quit();
	}
	
	public void DeleteResource()
	{
		String username = "rmdom2008\\room.manager";
		String password = "M@nager";
		String name = "newResource";
		String displayName = "newResource";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectResourcesOption()
		.SelectResource()
		.RemoveResource()
		.Remove()
		.VerifyResourceWasDeleted(name, displayName);
		
		BrowserManager.getInstance().getBrowser().quit();	
	}
	
	public static void main(String[] args) {
		ResourcesTest main = new ResourcesTest();		
//		main.CreateResource();
//		main.DeleteResource();
		main.UpdateResourceName();
	}

}
