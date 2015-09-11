package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
//import org.rm.automation.admin.pageobjects.LoginPage;
import org.testng.annotations.*;

import framework.ReadPropertyValues;
import framework.StartTest;
import framework.browser.BrowserManager;
import framework.home.LoginPage;
import rest.ResourcesRequests;

public class CreateResource extends TestBaseSetup {
	Properties settings = ReadPropertyValues
			.getPropertyFile("./Config/settings.properties");
	String username = settings.getProperty("username");
	String password = settings.getProperty("password");
	String name = "newResource";
	String displayName = "newResource";
	private WebDriver driver;
	private LoginPage loginPage;
	
	@BeforeClass
  	public void setUp() throws Exception {
	  driver=getDriver();
	}
	
	@Test
	public void CreateResource()
	{
		System.out.println("Enter Create Resource Test Case");
		loginPage = new LoginPage(driver)
		  		.SignIn(username, password)
		  		.SelectResourcesOption()
				.AddResource()
				.setName(name)
				.setDisplayName(displayName)
				.Save()
				.VerifyResourceWasCreated(name, displayName)
				.SignOut();
		
		
		
	}
	
	@AfterTest
	public void Postconditions()
	{
		System.out.println("After Test - Create Resource");
		String id = "";
		try {
		id = ResourcesRequests.getResourceId(name);
		ResourcesRequests.deleteResource(id);
//		BrowserManager.getInstance().getBrowser().quit();
	
		} catch (UnsupportedOperationException | IOException e) {
		e.printStackTrace();
		}
	}
}
