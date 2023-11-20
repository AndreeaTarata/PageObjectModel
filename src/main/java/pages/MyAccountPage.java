package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By userField = By.id("username");
	public By passField = By.id("password");
	public By loginButton = By.cssSelector("button[name='login']");
	public By errorMsg = By.cssSelector("ul[class='woocommerce-error'] strong");
	public By succesMsg = By.cssSelector("div[class='woocommerce-MyAccount-content']");
	public By logoutButton = By.xpath("//a[contains(text(), 'Log out')]");
	
	public void loginInApp(String user, String pass){
		sendKeys(userField, user);
		sendKeys(passField, pass);
		click(loginButton);
		
		
	}
}

