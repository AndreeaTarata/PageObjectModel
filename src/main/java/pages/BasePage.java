package pages;

import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class BasePage extends SeleniumWrappers {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public MenuPage menu = new MenuPage(driver);
	public MyAccountPage MyAccount = new MyAccountPage(driver);
	public RomansBooks romanBooks = new RomansBooks(driver);

}
