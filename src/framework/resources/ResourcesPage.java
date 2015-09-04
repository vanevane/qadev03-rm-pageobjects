package framework.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.browser.BrowserManager;
import framework.common.NavigationBarPage;

import java.util.concurrent.TimeUnit;


public class ResourcesPage extends NavigationBarPage{
	
	public AddResourcesPage AddResource()
	{
		WaitByXPath("//div/div/button");
//		for (int second = 0;; second++) {
//	    	if (second >= 60) fail("timeout");
//	    	try { if (isElementPresent(By.xpath("//div/div/button"))) break; } catch (Exception e) {}
////	    	Thread.sleep(1000);
//	    }
		
		WebElement add = BrowserManager.getInstance().getBrowser().findElement(By.xpath("//div/div/button"));
		add.click();
//		nameR.sendKeys(name);
//		
//		WebElement nameR = BrowserManager.getInstance().getBrowser().findElement(By.id("j_id_v:userName"));
//		nameR.sendKeys(name);
//		driver.findElement(By.xpath("//div/div/button")).click();
//	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
//	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("newResource");
//	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).clear();
//	    driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("newResource");
//	    driver.findElement(By.cssSelector("button.info")).click();
	    
		return new AddResourcesPage();
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
	
	/**
	 * Verify section
	 */

	
	public ResourcesPage VerifyResourceWasCreated()
	{
//	WaitByXPath(path);
		
//		for (int second = 0;; second++) {
//	    	if (second >= 60) fail("timeout");
//	    	try { if (isElementPresent(By.linkText("Conference Rooms"))) break; } catch (Exception e) {}
////	    	Thread.sleep(1000);
//	    }
		
		SelectRoomsOption();
		SelectResourcesOption();
		
//		WebElement menu = BrowserManager.getInstance().getBrowser().findElement(By.linkText("Conference Rooms"));
//		menu.click();
//		BrowserManager.getInstance().getBrowser().manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
//		WebDriverWait wait = new WebDriverWait(BrowserManager.getInstance().getBrowser(), 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("j_id_v:ci")));
		
//		menu = BrowserManager.getInstance().getBrowser().findElement(By.linkText("Resources"));
//		menu.click();
		
		String name = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.cssSelector("div.ngCell.centeredColumn.col2.colt2"))
				.getText()
				.replaceAll("\\s","");
		
		System.out.println(name);
		System.out.println("newResource");
		
		assertEquals("newResource", name);
		
		return this;
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
