package framework.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.browser.BrowserManager;
import framework.common.NavigationBarPage;
import framework.resources.ResourcesPage;
import utils.Waiters;

public class HomePage extends NavigationBarPage{	
	
	public LoginPage SingOut()
	{
		Waiters.WaitByCss("a > span");;
		
		WebElement singout = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.cssSelector("a > span"));
		singout.click();
		
		return new LoginPage();
		//a > span
	}
}
