package framework.common;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.browser.BrowserManager;
import framework.conferenceRooms.ConferenceRoomsPage;
import framework.emailServers.EmailServersPage;
import framework.resources.ResourcesPage;
import utils.Waiters;

public class NavigationBarPage {
	public ResourcesPage SelectResourcesOption()
	{
		Waiters.WaitByLinkText("Resources");
		
		WebElement resources = BrowserManager.getInstance().getBrowser().findElement(By.linkText("Resources"));
		resources.click();
		
		return new ResourcesPage();
	}
	
	public ConferenceRoomsPage SelectRoomsOption()
	{
		Waiters.WaitByLinkText("Conference Rooms");
		
		WebElement resources = BrowserManager.getInstance().getBrowser().findElement(By.linkText("Conference Rooms"));
		resources.click();
		
		return new ConferenceRoomsPage();
	}
	
	public EmailServersPage SelectEmailServersOption()
	{
		Waiters.WaitByLinkText("Email Servers");
		
		WebElement resources = BrowserManager.getInstance().getBrowser().findElement(By.linkText("Email Servers"));
		resources.click();
		
		return new EmailServersPage();
	}
	
//	private boolean isElementPresent(By by) {
//	    try {
//	    	BrowserManager.getInstance().getBrowser().findElement(by);
//	      return true;
//	    } catch (NoSuchElementException e) {
//	      return false;
//	    }
//	  }
	
//	private void WaitByLinkText(String link)
//	{
//		WebDriverWait wait = new WebDriverWait(BrowserManager
//				.getInstance()
//				.getBrowser(), 10);
//		
//		wait.until(ExpectedConditions
//				.presenceOfElementLocated(By.linkText(link)));
//	}

}
