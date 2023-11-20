package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Utils.BaseTest;

public class LoginTest extends BaseTest{
	
	@Parameters({"user", "pass"})
	@Test
	public void validLogin(String user, String pass) {
		
		app.click(app.menu.myAccountLink);
		app.MyAccount.loginInApp(user, pass); // ii primeste din parameters - deci trebuie sa existe ca parametrii ai metodei
	}

}
