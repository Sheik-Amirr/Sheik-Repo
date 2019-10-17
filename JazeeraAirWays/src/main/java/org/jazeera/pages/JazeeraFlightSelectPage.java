package org.jazeera.pages;

import java.util.List;

import org.jazeera.commons.Jazeera_ProjectSpecificMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JazeeraFlightSelectPage extends Jazeera_ProjectSpecificMethods {

	public JazeeraFlightSelectPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@href='#tab4']//span")
	WebElement eleOutbiundAvail;
	@FindBy(how = How.XPATH, using = "//div[@id='tab4']//following::input[contains(@name,'InputSelectView$market1')]")
	List<WebElement> eleAllFlights;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'RadioButtonMkt1Fare2')]")
	WebElement selectEconomy;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'flight_day glide_left')]")
	WebElement eleFlightDate;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'flight_airportSelect flight_number')]")
	WebElement eleFlightNum;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'flight_destination glide_left')]")
	WebElement eleFromCityName;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'flight_destination glide_right')]")
	WebElement eleToCityName;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'flight_time textColor glide_left')]//following::span)[1]")
	WebElement eleFlightDepTime;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'flight_time textColor glide_right')]//following::span)[1]")
	WebElement eleFlightArrTime;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ControlGroupSelectView_ButtonSubmit')]")
	WebElement eleSearchFlight;

	public JazeeraFlightSelectPage selectFlight() throws Exception {
		try {
			String givenDateFlight = eleOutbiundAvail.getText();
			if (givenDateFlight.equalsIgnoreCase("Best Prices")) {

				// eleAllFlights.get(0).click();
				click(eleAllFlights.get(0), "Select Flight Radio Button");
				System.out.println("Flight selected for given date");
			}

			else if (givenDateFlight.equalsIgnoreCase("No Flights Available")) {
				System.out.println("No Flights Available on selected date. Selecting next possible Flight");

				List<WebElement> allAvailFlights = driver
						.findElementsByXPath("//*[contains(@class,'tabset')]//span[text()='Best Prices']");
				allAvailFlights.get(0).click();

				List<WebElement> allAvailRadioButton = driver
						.findElementsByXPath("//*[contains(@id,'AvailabilityInputSelectView_RadioButton')]");
				allAvailRadioButton.get(0).click();
			} else {
				System.out.println("Changing to next week list");
				driver.findElementByXPath("//*[contains(@id,'_searchNextLink_1')]").click();
				List<WebElement> allAvailFlights = driver
						.findElementsByXPath("//*[contains(@class,'tabset')]//span[text()='Best Prices']");
				allAvailFlights.get(0).click();

				List<WebElement> allAvailRadioButton = driver
						.findElementsByXPath("//*[contains(@id,'AvailabilityInputSelectView_RadioButton')]");
				allAvailRadioButton.get(0).click();

			}
			System.out.println("Selected Flight date: " + eleFlightDate.getText());
			System.out.println("Flight NO: " + eleFlightNum.getText());
			System.out.println("From City: " + eleFromCityName.getText());
			System.out.println("To City: " + eleToCityName.getText());
			System.out.println("Depature Time: " + eleFlightDepTime.getText());
			System.out.println("Arrival Time: " + eleFlightArrTime.getText());
			return this;

		} catch (Exception e) {
			System.err.println("Flight Selection Failed");
			throw new Exception();
		}

	}

	/*
	 * public JazeeraFlightSelectPage selectOutbound() {
	 * System.out.println("Page Name: " + driver.getTitle()); try { if
	 * (eleOutbiundAvail.isDisplayed()) { eleAllFlights.get(0).click();
	 * System.out.println("Selected given date's Flight"); } } catch (Exception e) {
	 * for (int i = 4; i <= 7; i++) { if (driver .findElementByXPath(
	 * "//a[@href='#tab" + i + "']//following::span[text()='No Flights Available']")
	 * .isDisplayed()) { System.out.
	 * println("No Flights Available on selected date. Selecting next possible Flight"
	 * );
	 * 
	 * driver.findElementByXPath("//a[@href='#tab" + (i + 1) + "']").click();
	 * List<WebElement> selectFlight = driver.findElementsByXPath("//div[@id='tab" +
	 * (i + 1) + "']//following::input[contains(@name,'InputSelectView$market1')]");
	 * selectFlight.get(0).click();
	 * 
	 * break; } } }
	 * 
	 * System.out.println("Selected Flight date: " + eleFlightDate.getText());
	 * System.out.println("Flight NO: " + eleFlightNum.getText());
	 * System.out.println("From City: " + eleFromCityName.getText());
	 * System.out.println("To City: " + eleToCityName.getText());
	 * System.out.println("Depature Time: " + eleFlightDepTime.getText());
	 * System.out.println("Arrival Time: " + eleFlightArrTime.getText()); return
	 * this; }
	 * 
	 */
	/*
	 * public JazeeraFlightSelectPage selectEconomy() { selectEconomy.click();
	 * return this; }
	 */

	public JazeeraPassengerInfoPage clickBookNow() throws Exception {
		// eleSearchFlight.click();
		click(eleSearchFlight, "Book Now Button");
		return new JazeeraPassengerInfoPage();
	}

}
