package framework.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.browser.BrowserManager;

public class DeleteResourcesPage {
	WebElement element;
	public ResourcesPage Remove()
	{
		WebElement accept = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.cssSelector("button.info"));
		accept.click();
		
		return new ResourcesPage();
	}
}
