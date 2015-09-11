package framework.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.browser.BrowserManager;
import utils.Waiters;

public class DeleteResourcesPage {	
	private WebElement element;
	private WebDriver driver;
	
	public DeleteResourcesPage(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * Method to click the Remove button
	 * @return
	 */
	public ResourcesPage Remove()
	{
		Waiters.WaitByCss("button.info", driver);
		
		element = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.cssSelector("button.info"));
		element.click();
		
		return new ResourcesPage(driver);
	}
}
