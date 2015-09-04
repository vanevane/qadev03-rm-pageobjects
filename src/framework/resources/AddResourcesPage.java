package framework.resources;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.browser.BrowserManager;

public class AddResourcesPage {
	
	public AddResourcesPage setName(String name)
	{
		WaitByXPath("(//input[@type='text'])[3]");
//		for (int second = 0;; second++) {
//	    	if (second >= 60) fail("timeout");
//	    	try { if (isElementPresent(By.xpath("(//input[@type='text'])[3]"))) break; } catch (Exception e) {}
////	    	Thread.sleep(1000);
//	    }
		
		WebElement nameR = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.xpath("(//input[@type='text'])[3]"));
		nameR.sendKeys(name);
		
		return this;
	}
	
	public AddResourcesPage setDisplayName(String displayName)
	{
		WebElement displayNameR = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.xpath("(//input[@type='text'])[4]"));
		displayNameR.sendKeys(displayName);
		
		return this;
	}
	
	public ResourcesPage CreateResource()
	{
		WebElement accept = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.cssSelector("button.info"));
		accept.click();;
		//By.cssSelector("button.info")
		
		return new ResourcesPage();
	}
	
	private boolean isElementPresent(By by) {
	    try {
	    	BrowserManager.getInstance().getBrowser().findElement(by);
//	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
	private void WaitByXPath(String path)
	{
		WebDriverWait wait = new WebDriverWait(BrowserManager
				.getInstance()
				.getBrowser(), 10);
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(path)));
		
//		BrowserManager.getInstance().getBrowser().manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
	}

}
