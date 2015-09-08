package tests;

import org.testng.annotations.Test;

import framework.StartTest;
import framework.browser.BrowserManager;

public class ResourcesTestCases {
	
  @Test
  public void CreateResource() {
	  String username = "rmdom2008\\room.manager";
		String password = "M@nager";
		String name = "newResource";
		String displayName = "newResource";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectResourcesOption()
		.AddResource()
		.setName(name)
		.setDisplayName(displayName)
		.Save()
		.VerifyResourceWasCreated(name, displayName);
//		.SelectResource()
//		.RemoveResource()
//		.Remove();
		
		BrowserManager.getInstance().getBrowser().quit();
  }
  
  @Test
  public void UpdateResourceName()
	{
		String username = "rmdom2008\\room.manager";
		String password = "M@nager";
		String name = "newResourceEdit";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectResourcesOption()
		.UpdateResource()
		.setName(name)
		.Save()
		.VerifyResourceNameWasUpdated(name);
		
		BrowserManager.getInstance().getBrowser().quit();
	}
	
  @Test
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
}
