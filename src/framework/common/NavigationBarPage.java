package framework.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.browser.BrowserManager;
import framework.conferenceRooms.ConferenceRoomsPage;
import framework.emailServers.EmailServersPage;
import framework.resources.ResourcesPage;
import utils.Waiters;

public class NavigationBarPage {
	/*-------------------------------------------*/
	protected WebDriver driver;
	private By locationsLink = By.linkText("Locations");
	private By issuesLink = By.linkText("Issues");
	private By resourcesLink = By.linkText("Resources");
	private By roomsLink = By.linkText("Conference Rooms");
	
	public NavigationBarPage(WebDriver driver) {
		this.driver = driver;
	}
//	public LocationsPage SelectLocationsOption()
//	{
//		WebElement element=driver.findElement(locationsLink);
//		if(element.isDisplayed()||element.isEnabled())
//			element.click();
//		return new LocationsPage(driver);
//	}
//	public IssuesPage  SelectIssuesOption() {
//		WebElement element=driver.findElement(issuesLink);
//		if(element.isDisplayed()||element.isEnabled())
//			element.click();
//		return new IssuesPage(driver);
//	}
	
	public ResourcesPage SelectResourcesOption()
	{
		
		Waiters.WaitByLinkText("Resources", driver);
		System.out.println("Searching Resources link");
		
		WebElement element=driver.findElement(resourcesLink);
//		if(element.isDisplayed()||element.isEnabled())
			element.click();
		
		return new ResourcesPage(driver);
	}
	
	
	public ConferenceRoomsPage SelectRoomsOption()
	{
		Waiters.WaitByLinkText("Conference Rooms", driver);
		
		WebElement element=driver.findElement(roomsLink);
		if(element.isDisplayed()||element.isEnabled())
			element.click();
		
		return new ConferenceRoomsPage(driver);
	}
	
	public EmailServersPage SelectEmailServersOption()
	{
		Waiters.WaitByLinkText("Email Servers", driver);
		
		WebElement resources = BrowserManager.getInstance().getBrowser().findElement(By.linkText("Email Servers"));
		resources.click();
		
		return new EmailServersPage();
	}

}
