package com.testframework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author Rodrigo Avila Gonzalez
 *
 */

public class BaseWeb {

	private WebDriver driver;
	
	
	public BaseWeb(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return browser selected driver
	 */
	public WebDriver driverConnection() {
		File file = new File("App.config");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		switch (prop.getProperty("browser")) {
		case "chrome": {

			System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			openPage(prop.getProperty("URL"));
			return driver;
		}
		case "firefox": {

			System.setProperty("webdriver.firefox.driver", "./src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			openPage(prop.getProperty("URL"));
			return driver;
		}
		case "edge": {

			System.setProperty("webdriver.edge.driver", "./src/main/resources/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			openPage(prop.getProperty("URL"));
			return driver;
		}
		default:
			System.out.println("Browser selected is not working or not supported!!!" + prop.getProperty("browser") + " , starting chrome instead.");
			System.setProperty("webdriber.chrome.driver", "./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			openPage(prop.getProperty("URL"));
			return driver;
		}
		
	}
	
	/**
	 * @action Closes the driver
	 */
	public void closeDriver() {
		driver.quit();
	}
	
	/**
	 * @param locator
	 * @return element found
	 */
	public WebElement findElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
	
	/**
	 * @param locator
	 * @return element found
	 */
	public List<WebElement> findElements(By locator){
		
		return driver.findElements(locator);
	}

	/**
	 * @param element
	 * @return Get text from web element
	 */
	public String getText(WebElement element) {
		
		return element.getText();
	}
	
	/**
	 * @param locator
	 * @return Get text from locator
	 */
	public String getText(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).getText();
	}
	
	/**
	 * @param locator
	 * @param inputText
	 * @action Type some text
	 */
	public void type(By locator,String inputText) {
		driver.findElement(locator).sendKeys(inputText);
	}

	/**
	 * @param locator
	 * @param inputText
	 * @action Type some text
	 */
	public void type(WebElement locator,String inputText) {
		locator.sendKeys(inputText);
	}
	
	/**
	 * @param locator
	 * @param inputText
	 * @action Type some text
	 */
	public void tapEnter(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}

	/**
	 * @param locator
	 * @param inputText
	 * @action Type some text
	 */
	public void tapEnter(WebElement locator) {
		locator.sendKeys(Keys.ENTER);
	}

	/**
	 * @param locator
	 * @action Click on element
	 */
	public void click(By locator) {
		
		driver.findElement(locator).click();
	}

	/**
	 * @param locator
	 * @action Click on element
	 */
	public void click(WebElement locator) {
		locator.click();
	}
	
	/**
	 * @param locator
	 * @return Return true or false if element is displayed
	 */
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchContextException e) {
			return false;
		}
	}
	
	/**
	 * @param locator
	 * @return Return true or false if element is displayed
	 */
	public Boolean isDisplayed(WebElement locator) {
		try {
			return locator.isDisplayed();
		} catch (org.openqa.selenium.NoSuchContextException e) {
			return false;
		}
	}

	/**
	 * @param url
	 * @action Open the page
	 */
	public void openPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	/**
	 * @param locator
	 * @action Mouse over to the locator
	 */
	public void mouseOver(By locator) {
		WebElement ele = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}

	/**
	 * @param locator
	 * @action Mouse over to the locator
	 */
	public void mouseOver(WebElement locator) {
		Actions action = new Actions(driver);
		action.moveToElement(locator).perform();
	}
	
	/**
	 * @param locator
	 * @return WebElements
	 */
	public List<WebElement> getElements(By locator) {
		List<WebElement> ele = driver.findElements(locator);

		return ele;
	}

	/**
	 * @param locator
	 * @action Wait for element
	 */
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * @param locator
	 * @action Wait for element
	 */
	public void waitForElement(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	/**
	 * @param locator
	 * @action Sleep
	 */
	public void waitFor(int seconds) throws InterruptedException {
		Thread.sleep(seconds * 1000);
	}
}