package Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pages.BasePage;

public class BaseTest extends Driver {
	
	private static final String Thred = null;
	public WebDriver driver;
	public BasePage app;
	
	
	@Parameters({"browser", "url"})
	@BeforeClass (alwaysRun = true)
	public void setup(String browser, String url) {
		
		
		driver = initDriver(browser);
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		
		app = new BasePage(driver);
	}

	@AfterClass (alwaysRun = true)
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(1000); //bad practice
		driver.quit(); //inchide toate ferestrele/ browserul indif de cate ferestre 
		//driver.close(); // inchide tabul curent
		
	}
	
}
