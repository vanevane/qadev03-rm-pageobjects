package framework;

import framework.home.LoginPage;

public class StartTest {
	
	public StartTest()
	{
		getLogin();
	}
	
	public static LoginPage getLogin() { 
          return new LoginPage();
	}
}
