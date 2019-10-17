package org.jazeera.commons;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jazeera.utils.ReadExcelLibrary;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

/**
 * @author Amirudeen. Created date: 04-10-2019
 */
public class Jazeera_ProjectSpecificMethods {

	public static RemoteWebDriver driver;
	public String enterExcelName;
	public static String totalFair;

	/**
	 * DropDown selection
	 */
	public void dropDown(WebElement element, String text, String dropdownName) {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(text);
			System.out.println("DropDown selected for " + dropdownName + " using Text: " + text);

		} catch (Exception e) {
			System.err.println("DropDown selection failed" + e);
		}
	}

	/**
	 * Performs click action
	 * 
	 * @throws Exception
	 */
	public void click(WebElement element, String eleName) throws Exception {
		try {
			element.click();
			System.out.println("Click action performed for: " + eleName);

		} catch (NoSuchElementException e) {
			System.err.println("No such element is found: " + eleName);
			throw new Exception();

		} catch (ElementClickInterceptedException e) {
			System.err.println("Element click is intercepted: " + eleName);
			throw new Exception();

		} catch (Exception e) {
			System.err.println(eleName + " - Element failure reason: " + e);
			throw new Exception();
		}
	}

	/**
	 * Performs Clear and then Type action
	 * 
	 * @throws Exception
	 */
	public void clearAndType(WebElement element, String data, String eleName) throws Exception {
		try {
			element.clear();
			element.sendKeys(data);
			System.out.println("Data passed using sendkeys for the element: " + eleName);

		} catch (ElementNotInteractableException e) {
			System.err.println("Element is not interactable: " + eleName);
			throw new Exception();

		} catch (NoSuchElementException e) {
			System.err.println("No such element is found: " + eleName);
			throw new Exception();

		} catch (Exception e) {
			System.err.println(eleName + " - Element failure reason: " + e);
			throw new Exception();
		}
	}

	@Parameters({ "browser", "url" })
	@BeforeMethod
	public void wakeUpBrowser(String browser, String url) {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void killBrowser() {
		driver.close();
		driver.quit();
	}

	@DataProvider(name = "jazeeraDataBase")
	public String[][] dataBase() throws IOException {
		String[][] data = ReadExcelLibrary.readExcel(enterExcelName);
		return data;

	}

}
