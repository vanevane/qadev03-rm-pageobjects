package framework.resources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import org.bouncycastle.jcajce.provider.asymmetric.util.ExtendedInvalidKeySpecException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.browser.BrowserManager;
import framework.common.NavigationBarPage;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ResourcesPage extends NavigationBarPage{

	WebElement element;
	
	/**
	 * Method to select the Add tab
	 * @return
	 */
	public AddResourcesPage AddResource()
	{
		WaitByXPath("//div/div/button");
		
		WebElement element = BrowserManager.getInstance().getBrowser().findElement(By.xpath("//div/div/button"));
		element.click();
	    
		return new AddResourcesPage();
	}
	
	/**
	 * Method to select the checkbox in the resources table
	 * @return
	 */
	public ResourcesPage SelectResource()
	{
		WaitByCss("input.ngSelectionCheckbox");
		
		WebElement checkbox;
		List<WebElement> list = GetListResources();
		
		checkbox = list.get(list.size()-1).findElement(By.cssSelector("input.ngSelectionCheckbox"));
		checkbox.click();
		
		return this;
	}
	
	/**
	 * Method to select the Remove tab
	 * @return
	 */
	public DeleteResourcesPage RemoveResource()
	{
		element = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.id("btnRemove"));
		element.click();
		
		return new DeleteResourcesPage();
	}
	
	/**
	 * Method to update the last resource of the table
	 * @return
	 */
	public AddResourcesPage UpdateResource()
	{
		List<WebElement> list = GetListResources();
		element = list.get(list.size()-1);
		
		Actions action = new Actions(BrowserManager.getInstance().getBrowser());
		action.moveToElement(element.findElement(By.cssSelector("div.ng-scope > span.ng-binding"))).doubleClick().build().perform();
		
		return new AddResourcesPage();
	}
	
	/**
	 * Method to get a list of the resources
	 * @return
	 */
	public List<WebElement> GetListResources()
	{
		WebElement element2;
		WebElement element3;
		
		element = BrowserManager
				.getInstance()
				.getBrowser()
				.findElement(By.id("resourcesGrid"));//		
		
		element2 = element.findElement(By.xpath("div[2]"));
		element3 = element2.findElement(By.tagName("div"));
		
		List<WebElement> listEven = element3.findElements(By.cssSelector("div.ng-scope.ngRow.even"));
		List<WebElement> listOdd = element3.findElements(By.cssSelector("div.ng-scope.ngRow.odd"));
		
		if (listEven.size() > listOdd.size()) {
			return listEven;
		}
		else if(listEven.size() == listOdd.size()){
			return listOdd;
		}
		return null;
	}

	
	/**
	 * Verify section
	 */
	public ResourcesPage VerifyResourceWasCreated(String expName, String expDisplayName)
	{
		WebElement nameElement;
		WebElement displayNameElement;
//		
		SelectRoomsOption();
		SelectResourcesOption();
		
		List<WebElement> list = GetListResources();
		
		nameElement = list.get(list.size()-1).findElement(By.cssSelector("div.ngCell.centeredColumn.col2.colt2"));
		String name = nameElement.getText().replaceAll("\\s","");
		
		displayNameElement = list.get(list.size()-1).findElement(By.cssSelector("div.ngCell.centeredColumn.col3.colt3"));
		String displayName = displayNameElement.getText().replaceAll("\\s","");
		
		System.out.println(nameElement);
		System.out.println(displayNameElement);
		assertEquals(expName, name);
		assertEquals(expDisplayName, displayName);
		
		return this;
	}
	
	public ResourcesPage VerifyResourceWasDeleted(String expName, String expDisplayName)
	{
		List<WebElement> list = GetListResources();
		
		WebElement nameElement;
		WebElement displayNameElement;
		
		SelectRoomsOption();
		SelectResourcesOption();
		
		nameElement = list.get(list.size()-1).findElement(By.cssSelector("div.ngCell.centeredColumn.col2.colt2"));
		String name = nameElement.getText().replaceAll("\\s","");
		
		displayNameElement = list.get(list.size()-1).findElement(By.cssSelector("div.ngCell.centeredColumn.col3.colt3"));
		String displayName = displayNameElement.getText().replaceAll("\\s","");
		
		System.out.println(nameElement);
		System.out.println(displayNameElement);
//		System.out.println("newResource");
		assertNotEquals(expName, name);
		assertNotEquals(expDisplayName, displayName);
		
		return this;
	}
	
	/**
	 * Wait by path
	 * @param path
	 */
	private void WaitByXPath(String path)
	{
		WebDriverWait wait = new WebDriverWait(BrowserManager
				.getInstance()
				.getBrowser(), 10);
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(path)));
	}
	
	/**
	 * Wait by css
	 * @param path
	 */
	private void WaitByCss(String path)
	{
		WebDriverWait wait = new WebDriverWait(BrowserManager
				.getInstance()
				.getBrowser(), 5);
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector(path)));
	}
	
	/**
	 * Wait by id
	 * @param id
	 */
	private void WaitById(String id)
	{
		WebDriverWait wait = new WebDriverWait(BrowserManager
				.getInstance()
				.getBrowser(), 5);
		
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.id(id)));
	}
}
