package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Utils.BaseTest;
import Utils.ScrenShots;

public class LoginTest extends BaseTest{
	
	@Parameters({"user", "pass"})
	@Test(priority =1)
	public void validLogin(String user, String pass) throws IOException {
		
		app.click(app.menu.myAccountLink);
		app.MyAccount.loginInApp(user, pass); // ii primeste din parameters - deci trebuie sa existe ca parametrii ai metodei
		
		assertTrue(app.elementIsDispayed(app.MyAccount.succesMsg));
		//ScrenShots.screenshot(driver);
		app.click(app.MyAccount.logoutButton);
	}
	
	@Test(priority =2)
	public void invalidLogin() {
		
		app.click(app.menu.myAccountLink);
		app.MyAccount.loginInApp("usergresit", "passgresit"); // ii primeste din parameters - deci trebuie sa existe ca parametrii ai metodei
		
		assertTrue(app.elementIsDispayed(app.MyAccount.errorMsg));
		
	}

}
