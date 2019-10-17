package org.jazeera.pages;

import java.util.List;

import org.jazeera.commons.Jazeera_ProjectSpecificMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JazeeraSeatSelectionPage extends Jazeera_ProjectSpecificMethods {

	public JazeeraSeatSelectionPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'unitGroup1') and contains(@style,'Open')]")
	List<WebElement> elePrioritySeats;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'unitGroup2') and contains(@style,'Open')]")
	List<WebElement> elePreferredSeats;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'unitGroup3') and contains(@style,'Open')]")
	List<WebElement> eleLegRoomSeats;
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'unitGroup4') and contains(@style,'Open')]")
	List<WebElement> eleStandardSeats;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'assignseats_0_0')]")
	WebElement eleSeatID;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'amountBox')]//following::p)[1]")
	WebElement eleSeatRate;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'flight_total_detail seatgrandTotal centralize')]")
	WebElement eleTotalFare;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'button')]//following::em")
	WebElement eleContinue;

	public JazeeraSeatSelectionPage selectSeat(String seatType) throws Exception {
		System.out.println("Page Name: " + driver.getTitle());
		try {
			switch (seatType) {

			case "prioritySeat":
				// elePrioritySeats.get(0).click();
				click(elePrioritySeats.get(0), "Priority Seats");
				System.out.println("Selected Seat ID :" + eleSeatID.getText());
				System.out.println("Selected Seat Price in INR: " + eleSeatRate.getText());
				break;

			case "PreferredSeat":
				// elePreferredSeats.get(0).click();
				click(elePreferredSeats.get(0), "Preferred Seats");
				System.out.println("Selected Seat ID :" + eleSeatID.getText());
				System.out.println("Selected Seat Price in INR: " + eleSeatRate.getText());
				break;

			case "LegRoomSeat":
				// eleLegRoomSeats.get(0).click();
				click(eleLegRoomSeats.get(0), "Leg Room Seats");
				System.out.println("Selected Seat ID :" + eleSeatID.getText());
				System.out.println("Selected Seat Price in INR: " + eleSeatRate.getText());
				break;

			case "StandardSear":
				// eleStandardSeats.get(0).click();
				click(eleStandardSeats.get(0), "Standard Seats");
				System.out.println("Selected Seat ID :" + eleSeatID.getText());
				System.out.println("Selected Seat Price in INR: " + eleSeatRate.getText());
				break;
			}
			totalFair = eleTotalFare.getText().replaceAll("\\D", "");
			System.out.println("Total Amount after Seat Selection: " + totalFair);
			return this;
		} catch (Exception e) {
			System.err.println("Seat selection failed" + e);
			throw new Exception();
		}
	}

	public JazeeraPaymentPage clickSeatContinue() throws Exception {
		// eleContinue.click();
		click(eleContinue, "Seat Continue Button");
		return new JazeeraPaymentPage();
	}

}
