package tests;

import framework.StartTest;
import framework.browser.BrowserManager;
import org.testng.annotations.Test;

public class ResourcesTest {
	
	@Test
	public void CreateResource()
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
