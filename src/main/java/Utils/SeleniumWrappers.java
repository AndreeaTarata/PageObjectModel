package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest {

	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;

	}

	public void click(By locator) {

		Log.info("started method <clieck> on locator" + locator.toString());
		WebElement element = returnWebElement(locator);
		try {

			waitForTheElementToBeClickable(locator);
			element.click();
			Log.info("clieck() was sucessfull on locator" + locator.toString());
		} catch (StaleElementReferenceException e) {
			Log.error("catched<StaleElementReferenceException> on locator" + locator.toString());
			element = returnWebElement(locator);
			element.click();
		} catch (Exception e) {
			// Log.error(e.getMessage());
			throw new TestException("Element not found in click");

		}
	}

	public void sendKeys(By locator, String text) {
		
		Log.info("started method <sendkeys()> on locator" + locator.toString());
		WebElement element = returnWebElement(locator);
		waitForElementToBeVisible(locator);

		try {
			Log.info("started method <sendkeys()> on locator" + locator.toString());
			element.clear();
			Log.info("started method <sendkeys()> on locator" + locator.toString());
			element.sendKeys(text);

		} catch (Exception e) {
			// Log.error(e.getMessage());
			throw new TestException("Element not found in <sendKeys>");

		}
	}

	public void waitForTheElementToBeClickable(By locator) {
		try {
			Log.info("started method <waitForTheElementToBeClickable> on locator" + locator.toString());
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(locator));

		} catch (Exception e) {
			// Log.error(e.getMessage());
			throw new TestException("Element not found in <waitForTheElementToBeClickable> after 30 seconds");

		}
	}

	public WebElement returnWebElement(By locator) {
		waitForElementToBeVisible(locator);// se declanseaza doar daca are nevoie
		return driver.findElement(locator);
	}

	public WebElement simpleReturnWebElement(By locator) {

		return driver.findElement(locator);
	}

	public void waitForElementToBeVisible(By locator) {
		Log.info("started method <waitForElementToBeVisible> on locator" + locator.toString());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void confirmJsAlert() throws InterruptedException {

		driver.switchTo().alert().accept();

	}

	public void scrollPge(int x) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + x + ")");

	}

	public boolean elementIsDispayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public void hoverElement(By locator) {
		// clasa Action

		Actions action = new Actions(driver);
		action.moveToElement(returnWebElement(locator)).perform();

	}

	public void dragAndDrop(By locator, int x, int y) {
		Actions action = new Actions(driver);
		// action.dragAndDropBy(null, 0, 0).perform();
		action.clickAndHold(returnWebElement(locator)).moveByOffset(x, y).release().perform();// acelasi lucru ca drag
																								// and drop

	}

	public void scrollHorizontally(int x) {

		Actions action = new Actions(driver);
		action.scrollByAmount(x, 0).perform();
	}

	public void scrollVertically(int y) {

		Actions action = new Actions(driver);
		action.scrollByAmount(0, y).perform();
	}

	public void scrollToElement() {

	}
}
