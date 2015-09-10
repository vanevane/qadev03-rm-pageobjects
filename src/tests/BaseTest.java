package tests;

import org.testng.annotations.Test;

import framework.browser.BrowserManager;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	
 
  @BeforeSuite
  public void beforeSuite() {
	  BrowserManager.getInstance();
  }

  @AfterSuite
  public void afterSuite() {
	  BrowserManager.getInstance().getBrowser().quit();
  }

}
