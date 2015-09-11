package tests;

import org.testng.annotations.Test;

import framework.StartTest;
import framework.browser.BrowserManager;

public class EmailServersTestCases {
	
	@Test(priority=2)
	public void AddEmailServer()
	{
		String username = "rmdom2008\\room.manager";
		String password = "M@nager";
		
		String hostname = "rmdom2008.lab";
		String usernameEx = "Administrator";
		String passwordEx = "Control123";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectEmailServersOption()
		.AddEmailServer()
		.SetHostname(hostname)
		.SetUsername(usernameEx)
		.SetPassword(passwordEx)
		.Save()
		.VerifyEmailServerWasAdded(hostname);		
	}
	
	@Test(priority=1)
	public void RemoveEmailServer()
	{
		String username = "rmdom2008\\room.manager";
		String password = "M@nager";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectEmailServersOption()
		.RemoveEmailServer()
		.Remove()
		.VerifyEmailServerWasRemoved();
		
		BrowserManager.getInstance().getBrowser().quit();
	}
}
