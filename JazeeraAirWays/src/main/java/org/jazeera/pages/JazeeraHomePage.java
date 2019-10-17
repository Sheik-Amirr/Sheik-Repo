package org.jazeera.pages;

import org.jazeera.commons.Jazeera_ProjectSpecificMethods;
import org.jazeera.utils.CalendarHandling;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JazeeraHomePage extends Jazeera_ProjectSpecificMethods {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	CalendarHandling calHandle = new CalendarHandling();

	public JazeeraHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "DropDownListCurrency")
	WebElement eleSelectCurrency;
	@FindBy(how = How.ID, using = "DropDownListCulture1")
	WebElement eleSelectLang;
	@FindBy(how = How.XPATH, using = "//*[contains(@value,'RoundTrip')]")
	WebElement eleRoundTrip;
	@FindBy(how = How.XPATH, using = "//*[contains(@value,'OneWay')]")
	WebElement eleOneWay;
	@FindBy(how = How.XPATH, using = "//*[contains(@value,'OpenJaw')]")
	WebElement eleMultiCity;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'fromInputbox')])[1]")
	WebElement eleFromCity;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'fromInputbox')])[2]")
	WebElement eleToCity;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'TextBoxMarketDate1')]")
	WebElement eleDepartCalendar;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'TextBoxMarketDate2')]")
	WebElement eleReturnCalendar;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'DropDownListPassengerType')])[1]")
	WebElement eleAdult;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'DropDownListPassengerType')])[2]")
	WebElement eleChild;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'DropDownListPassengerType')])[3]")
	WebElement eleInfant;
	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[3]")
	WebElement eleFlexiDate;
	@FindBy(how = How.XPATH, using = "(//*[contains(text(),'Search')]//preceding::a)[12]")
	WebElement eleSearch;

	// Choose currency type
	public JazeeraHomePage selectCurrency(String currency) {
		System.out.println("Page Name: " + driver.getTitle());
		dropDown(eleSelectCurrency, currency, "Currency");
		return this;
	}

	// Choose user language
	public JazeeraHomePage selectLang(String lang) {
		dropDown(eleSelectLang, lang, "Language");
		return this;
	}

	// Choose trip type
	public JazeeraHomePage selectTripType(String tripType) throws Exception {
		try {
			switch (tripType) {
			case "RoundTrip":
				//eleRoundTrip.click();
				click(eleRoundTrip, "RoundTrip");
				if (eleRoundTrip.isSelected()) {
					System.out.println("Round Trip is Selected");
				} else {
					System.err.println("Round Trip Selection Failed");
				}
				break;

			case "OneWay":
				//eleOneWay.click();
				click(eleOneWay, "OneWay");
				if (eleOneWay.isEnabled()) {
					System.out.println("One Way Trip is Selected");
				} else {
					System.err.println("One way Trip Selection Failed");
				}
				break;

			case "MultiCity":
				//eleMultiCity.click();
				click(eleMultiCity, "MultiCity");
				if (eleMultiCity.isEnabled()) {
					System.out.println("Multi City Trip is Selected");
				} else {
					System.err.println("Multi City Trip Selection Failed");
				}
				break;
			}
		} catch (NoSuchElementException e) {
			System.err.println("Trip Selection Failed due to No Element Found");
			throw new Exception();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Trip Selection Failed due to Element Interception");
			throw new Exception();
		} catch(Exception e) {
			System.err.println("Trip Selection Failed: "+e);
			throw new Exception();
		}
		return this;

	}

	// For selecting two cities (common for OneWay & RoundTrip)
	public JazeeraHomePage selectCityPair(String fromCity, String toCity) throws Exception {

		try {
			//eleFromCity.click();
			click(eleFromCity, "From City");
			//eleFromCity.sendKeys(fromCity);
			clearAndType(eleFromCity, fromCity, "From City");
			driver.findElementByXPath("(//span[text()='" + fromCity + "'])[1]").click();

			//eleToCity.click();
			click(eleToCity, "To City");
			//eleToCity.sendKeys(toCity);
			clearAndType(eleToCity, toCity, "To City");
			driver.findElementByXPath("(//span[text()='" + toCity + "'])[2]").click();
			
		} catch (NoSuchElementException e) {
			System.err.println("City Pair selection failed due to No Element Found");
			throw new Exception();
		} catch (ElementClickInterceptedException e) {
			System.err.println("City Pair selection failed due to Element Interception");
			throw new Exception();
		} catch (Exception e) {
			System.err.println("City Pair selection failed " + e);
			throw new Exception();
		}
		return this;
	}

	// Departure Calendar
	public JazeeraHomePage departCalendar(String dpYear, String dpMonth, String dpDate) throws Exception {

		WebElement departCal = wait.until(ExpectedConditions.visibilityOf(eleDepartCalendar));
		boolean depStatus = departCal.isDisplayed();
		if (depStatus) {
			System.out.println("Depart calendar element is visible");
		} else {
			System.err.println("Depart calendar element failed to show-up");

		}
		//departCal.click();
		click(departCal, "Depature Calendar");
		wait.until(ExpectedConditions.elementToBeClickable(eleDepartCalendar));
		calHandle.dateHandle(dpYear, dpMonth, dpDate);
		return this;
	}

	//// Return Calendar
	public JazeeraHomePage returnCalendar(String rtYear, String rtMonth, String rtDate) throws Exception {

		WebElement returnCal = wait.until(ExpectedConditions.visibilityOf(eleReturnCalendar));
		boolean retStatus = returnCal.isDisplayed();
		if (retStatus) {
			System.out.println("Return calendar element is visible");
		} else {
			System.err.println("Return calendar element failed to show-up");
		}
		//eleReturnCalendar.click();
		click(eleReturnCalendar, "Return Calendar");
		calHandle.dateHandle(rtYear, rtMonth, rtDate);
		return this;
	}

	// Adult count selection
	public JazeeraHomePage selectAdult(String adult) {
		dropDown(eleAdult, adult, "Adult Passenger");
		return this;
	}

	// Child count selection
	public JazeeraHomePage selectChild(String child) {
		dropDown(eleChild, child, "Child Passenger");
		return this;
	}

	// Infant count selection
	public JazeeraHomePage selectInfant(String infant) {
		dropDown(eleInfant, infant, "Infant Passenger");
		return this;
	}

	// Flexible date On/Off
	public JazeeraHomePage flexiDate(String flexiChoice) throws Exception {
		//eleFlexiDate.click();
		click(eleFlexiDate, "Flexi Date");
		try {
			switch (flexiChoice) {
			case "FlexiON":
				if (eleFlexiDate.isSelected()) {
					System.out.println("Flexible Date CheckBox has already been enabled by default");
				} else {
					//eleFlexiDate.click();
					click(eleFlexiDate, "Flexi Date");
					System.out.println("Flexible Date CheckBox is enabled");
				}
				break;
				
			case "FlexiOFF":
				if (eleFlexiDate.isSelected()) {
					//eleFlexiDate.click();
					click(eleFlexiDate, "Flexi Date");
					System.out.println("Flexible Date CheckBox disabled");
				} else {
					System.out.println("Flexibel Date ChecBox has already been disabled by default");
				}
			}
		} catch (NoSuchElementException e) {
			System.err.println("Flexi Date Selection Failed due to No Element Found");
			throw new Exception();
		} catch (ElementClickInterceptedException e) {
			System.err.println("Flexi Date Selection Failed due to Element Interception");
			throw new Exception(); 
		} catch (Exception e) {
			System.err.println("Flexi Date CheckBox failure" + e);
			throw new Exception();
		}
		return this;
	}

	// Search flight
	public JazeeraFlightSelectPage searchFlight() throws Exception {
		eleSearch.click();
		click(eleSearch, "Flight Search Button");
		return new JazeeraFlightSelectPage();
	}

}
