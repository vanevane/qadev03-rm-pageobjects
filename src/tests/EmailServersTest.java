package tests;

import java.io.IOException;

import framework.StartTest;
import framework.browser.BrowserManager;

public class EmailServersTest {

	public void AddEmailServer()
	{
		System.out.println("ADD EMAIL SERVER");
		String username = "rmdom2008\\room.manager";
		String password = "M@nager";
		
		String hostname = "rmdom2008.lab";
		String usernameEx = "Administrator";
		String passwordEx = "Control123";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectEmailServersOption();
//		.AddEmailServer()
//		.SetHostname(hostname)
//		.SetUsername(usernameEx)
//		.SetPassword(passwordEx)
//		.Save();
//		.VerifyEmailServerWasAdded(hostname);
		
//		try {
//			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BrowserManager.getInstance().exit();
//		BrowserManager.getInstance().newInstance();
//		BrowserManager.getInstance().getBrowser().manage().
//		BrowserManager.getInstance().getBrowser().quit();
	}
	
	public void RemoveEmailServer()
	{
		System.out.println("REMOVE EMAIL SERVER");
		String username = "rmdom2008\\room.manager";
		String password = "M@nager";
		
		StartTest.getLogin()
		.setUsername(username)
		.setPassword(password)
		.login()
		.SelectEmailServersOption();
//		.RemoveEmailServer()
//		.Remove();
//		.VerifyEmailServerWasRemoved();
		
//		try {
//			Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		BrowserManager.getInstance().exit();
	}
	
	public static void main(String[] args) {
		EmailServersTest mail = new EmailServersTest();
		
		mail.AddEmailServer();
		mail.RemoveEmailServer();
	}
}
