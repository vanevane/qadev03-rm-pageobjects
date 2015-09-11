package framework;

import org.openqa.selenium.WebDriver;

import framework.home.LoginPage;

public class StartTest {
	static WebDriver d;
	public StartTest()
	{
		getLogin(d);
	}
	
	public static LoginPage getLogin(WebDriver driver) { 
		d = driver;
        return new LoginPage(driver);
	}
}
