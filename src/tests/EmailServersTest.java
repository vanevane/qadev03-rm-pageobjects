package tests;

import framework.StartTest;
import framework.browser.BrowserManager;

public class EmailServersTest {

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
		
		BrowserManager.getInstance().getBrowser().quit();
	}
	
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
	
	public static void main(String[] args) {
		EmailServersTest mail = new EmailServersTest();
		
//		mail.AddEmailServer();
		mail.RemoveEmailServer();
	}
}
