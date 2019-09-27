package org.testleaf.servicenow.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class P_S_Methods {
	public static RemoteWebDriver driver;
	public String enterExcelName;
	public static String genIncidentNum;

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
		//driver.quit();
	}

	@DataProvider(name = "serviceNowDB")
	public String[][] dataBase() throws IOException {
		String[][] data = ExcelLibrary.readExcel(enterExcelName);
		return data;

	}

}
