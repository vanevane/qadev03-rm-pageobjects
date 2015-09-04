package tests;

import framework.StartTest;
import framework.browser.BrowserManager;

public class ResourcesTest {
	
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
		.CreateResource()
		.VerifyResourceWasCreated();
		
		BrowserManager.getInstance().getBrowser().quit();
	}
	
	public void UpdateResourceName()
	{
		String username = "rmdom2008\\room.manager";
		String password = "M@nager";
		String name = "newResourceEdit";
//		String displayName = "newResource";
		
//		StartTest.getLogin()
//		.setUsername(username)
//		.setPassword(password)
//		.login()
//		.SelectResourcesOption()
//		.AddResource()
//		.setName(name)
//		.setDisplayName(displayName)
//		.CreateResource()
//		.VerifyResourceWasCreated();
		
		BrowserManager.getInstance().getBrowser().quit();
	}
	
	public void DeleteResources()
	{
		
	}
	
	public static void main(String[] args) {
		ResourcesTest main = new ResourcesTest();
		
		
//	    extent = ;
	    
//	    extent.config().documentTitle("JagdPanther Firefox Report");
//        extent.config().reportHeadline("Test report for JagdPanher applicant creation");
//	    
//        test = extent.startTest("TC01.1", "Positive Functional TC for Applicant creation");		
		main.CreateResource();
//		extent.endTest(test);
	}

}
