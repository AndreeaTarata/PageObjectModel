package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.SeleniumWrappers;

public class RomansBooks extends SeleniumWrappers {

	public RomansBooks(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public By romansProductCategory = By.cssSelector("a[href='https://keybooks.ro/product-category/romans/']");
	public By aBanketOfMouse = By.xpath("(//a[@href='https://keybooks.ro/shop/a-banquet-of-mouse/'])[6]");
	public By lifeInTheGarden = By.xpath("(//a[@href='https://keybooks.ro/shop/life-in-the-garden/'])[6]");
	public By lonelyManInWhiteHat = By.xpath("(//a[@href='https://keybooks.ro/shop/lonely-man-in-white-hat/'])[6]");
	public By theSon = By.xpath("(//a[@href='https://keybooks.ro/shop/the-son/'])[6]");
	public String curentRomanBooksUrl = "https://keybooks.ro/product-category/romans/";
	
	public boolean curentUrl(String curentRomanBooksUrl2) {
		return true;
	}
	public void openRomanBooks() {
		
		
		click(romansProductCategory);
	}
	
	public void openRomansBooksUrl(String book, String url) {
		
		
		driver.findElement(aBanketOfMouse).click();
		System.out.println("Current window before click on A Banket of Mouse" + driver.getWindowHandle());
		System.out.println("All windows:" + driver.getWindowHandles());
		
		List<String> browserTabs1 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs1.get(1));
		System.out.println("Current window after switch on: " + driver.getWindowHandle());
		driver.close();
		driver.switchTo().window(browserTabs1.get(0));
		
		
		driver.findElement(lifeInTheGarden).click();
		System.out.println("Current window before Life in the Garden" + driver.getWindowHandle());
		System.out.println("All windows:" + driver.getWindowHandles());
		
		List<String> browserTabs2 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs2.get(1));
		System.out.println("Current window after switch on: " + driver.getWindowHandle());
		driver.close();
		driver.switchTo().window(browserTabs2.get(0));
		
		
		driver.findElement(lonelyManInWhiteHat).click();
		System.out.println("Current window before click on Lonely man in white hat" + driver.getWindowHandle());
		System.out.println("All windows:" + driver.getWindowHandles());
		
		List<String> browserTabs3 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs3.get(1));
		System.out.println("Current window after switch on: " + driver.getWindowHandle());
		driver.close();
		driver.switchTo().window(browserTabs3.get(0));
		
		
		driver.findElement(theSon).click();
		System.out.println("Current window before click on The son" + driver.getWindowHandle());
		System.out.println("All windows:" + driver.getWindowHandles());
		
		List<String> browserTabs4 = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(browserTabs4.get(1));
		System.out.println("Current window after switch on: " + driver.getWindowHandle());
		driver.close();
		driver.switchTo().window(browserTabs4.get(0));
	}
		
			
			
		
		
		
		
	}
	


