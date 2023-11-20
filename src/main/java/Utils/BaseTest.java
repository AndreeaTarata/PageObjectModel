package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.google.common.io.Files;

import pages.BasePage;

public class BaseTest extends Driver {

	private static final String Thred = null;
	public WebDriver driver;
	public BasePage app;

	@Parameters({ "browser", "url" })
	@BeforeClass(alwaysRun = true)
	public void setup(String browser, String url) {

		driver = initDriver(browser);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);

		app = new BasePage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws InterruptedException {

		Thread.sleep(1000); // bad practice
		driver.quit(); // inchide toate ferestrele/ browserul indif de cate ferestre
		// driver.close(); // inchide tabul curent

	}

	@AfterMethod
	public void recordFailure(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			
		String timestamp = new SimpleDateFormat("yyy.MM.dd.hh.mm.ss").format(new Date());
		TakesScreenshot file = (TakesScreenshot) driver;

		File picture = file.getScreenshotAs(OutputType.FILE);

		Files.copy(picture, new File("poze/"+result.getName() +"_"+timestamp+".png"));
		
	}
}
}