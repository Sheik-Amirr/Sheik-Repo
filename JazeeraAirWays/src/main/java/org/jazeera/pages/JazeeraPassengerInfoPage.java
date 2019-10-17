package org.jazeera.pages;

import org.jazeera.commons.Jazeera_ProjectSpecificMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JazeeraPassengerInfoPage extends Jazeera_ProjectSpecificMethods {

	public JazeeraPassengerInfoPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'select-mr-mrs')])[1]")
	WebElement elePassengerTitle;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'TextBoxFirstName')])[2]")
	WebElement eleFName;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'TextBoxLastName')])[2]")
	WebElement eleLName;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'DropDownListGender_0')])[2]")
	WebElement eleGender;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'ContactInputView_DropDownListTitle')])[2]")
	WebElement eleConTitle;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'ContactInputView_TextBoxFirstName')])[2]")
	WebElement eleConFName;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'ContactInputView_TextBoxLastName')])[2]")
	WebElement eleConLName;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'TextBoxCity')]")
	WebElement eleContactCity;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'DropDownListCountry')])[3]")
	WebElement eleContactCountry;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'select-country-code')]")
	WebElement eleContactContryCode;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'TextBoxOtherPhone')])[2]")
	WebElement eleMobNum;
	@FindBy(how = How.XPATH, using = "(//*[contains(@id,'TextBoxEmailAddress')])[2]")
	WebElement eleEmail;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'CheckBoxPrevVisit')]")
	WebElement eleRetainDetailsCB;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'CheckBoxPromoOpt')]")
	WebElement elePromoUpdatesCB;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'CONTROLGROUPCONTACT_ButtonSubmit')]//following::em")
	WebElement eleClickContinue;

	public JazeeraPassengerInfoPage selectPassesngerTitle(String passTitle) {
		System.out.println("Page Name: " + driver.getTitle());
		dropDown(elePassengerTitle, passTitle, "Passenger Title");
		return this;
	}

	public JazeeraPassengerInfoPage enterPassesngerFName(String passFname) throws Exception {
		// eleFName.sendKeys(passFname);
		clearAndType(eleFName, passFname, "Passenger First Name");
		return this;
	}

	public JazeeraPassengerInfoPage enterPassesngerLName(String passLname) throws Exception {
		// eleLName.sendKeys(passLname);
		clearAndType(eleLName, passLname, "Passenger Last Name");
		return this;
	}

	public JazeeraPassengerInfoPage selectGender(String passGen) {
		dropDown(eleGender, passGen, "Passenger Gender");
		return this;
	}

	public JazeeraPassengerInfoPage selectcontactPassTitle(String conTitle) {
		dropDown(eleConTitle, conTitle, "Contact Title");
		return this;
	}

	public JazeeraPassengerInfoPage entercontactPassFName(String conFName) throws Exception {
		// eleConFName.clear();
		// eleConFName.sendKeys(conFName);
		clearAndType(eleConFName, conFName, "Contact First Name");
		return this;
	}

	public JazeeraPassengerInfoPage entercontactPassLName(String conLName) throws Exception {
		// eleConLName.clear();
		// eleConLName.sendKeys(conLName);
		clearAndType(eleConLName, conLName, "Contact Last Name");
		return this;
	}

	public JazeeraPassengerInfoPage enterConCity(String conCity) throws Exception {
		// eleContactCity.sendKeys(conCity);
		clearAndType(eleContactCity, conCity, "Contact City");
		return this;
	}

	public JazeeraPassengerInfoPage selectConCountry(String conCountry) {
		dropDown(eleContactCountry, conCountry, "Contact Country");
		return this;
	}

	public JazeeraPassengerInfoPage selectConCountryCode(String ConCntCode) {
		dropDown(eleContactContryCode, ConCntCode, "Contact Country Code");
		return this;
	}

	public JazeeraPassengerInfoPage enterConMobile(String conMoile) throws Exception {
		// eleMobNum.sendKeys(conMoile);
		clearAndType(eleMobNum, conMoile, "Contact Mobile Number");
		return this;
	}

	public JazeeraPassengerInfoPage enterConEmail(String conEmail) throws Exception {
		// eleEmail.sendKeys(conEmail);
		clearAndType(eleEmail, conEmail, "Contact Email");
		return this;
	}

	public JazeeraPassengerInfoPage retainConDetails(String retain) {
		try {
			switch (retain) {
			case "RetainDataON":

				if (eleRetainDetailsCB.isSelected()) {
					System.out.println("Retain Details is already enabled");
				} else {
					// eleRetainDetailsCB.click();
					click(eleRetainDetailsCB, "Retain Contact Details CheckBox");
					System.out.println("Retain Details checkbox is enabled");
				}
				break;

			case "RetainDataOFF":
				if (eleRetainDetailsCB.isSelected()) {
					// eleRetainDetailsCB.click();
					click(eleRetainDetailsCB, "Retain Contact Details CheckBox");
					System.out.println("Retain Details CheckBox is disabled");
				} else {
					System.out.println("Retain Details CheckBox is disabled by default");
				}
				break;

			}
		} catch (Exception e) {
			System.err.println("Retain Details CheckBox failed" + e);
		}
		return this;
	}

	public JazeeraPassengerInfoPage getPromoUpdates(String promoUpdates) {
		try {
			switch (promoUpdates) {
			case "promoON":
				if (elePromoUpdatesCB.isSelected()) {
					System.out.println("Promo-Update CheckBox is pre-clicked");
				} else {
					// elePromoUpdatesCB.click();
					click(elePromoUpdatesCB, "Promo Updates");
					System.out.println("Promo-Update CheckBox is enabled");
				}
				break;

			case "promoOFF":
				if (elePromoUpdatesCB.isSelected()) {
					// elePromoUpdatesCB.click();
					click(elePromoUpdatesCB, "Promo Updates");
					System.out.println("Promo-Update CheckBox is disabled");
				} else {
					System.out.println("Promo-Update CheckBox is disabled by default");
				}
				break;
			}
		} catch (Exception e) {
			System.err.println("Promo-Update CheckBox failed" + e);
		}
		return this;
	}

	public JazeeraSeatSelectionPage submitPassengerDetails() throws Exception {
		// eleClickContinue.click();
		click(eleClickContinue, "Passenger Details Submit Button");
		return new JazeeraSeatSelectionPage();
	}

}
