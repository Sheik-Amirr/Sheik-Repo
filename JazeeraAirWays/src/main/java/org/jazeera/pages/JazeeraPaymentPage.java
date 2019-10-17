package org.jazeera.pages;

import org.jazeera.commons.Jazeera_ProjectSpecificMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class JazeeraPaymentPage extends Jazeera_ProjectSpecificMethods {

	private String FinalTotalAmount;

	public JazeeraPaymentPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//*[contains(@class,'kNet')]")
	WebElement elekNet;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'creditCard')]")
	WebElement eleCreditCard;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'priceFormat')])[2]")
	WebElement eleCreditAmountPayable;
	@FindBy(how = How.XPATH, using = "//*[contains(@id,'ExternalAccount_PaymentMethodCode')]")
	WebElement eleCardType;
	@FindBy(how = How.XPATH, using = "(//input[contains(@id,'CONTROLGROUPPAYMENTBOTTOM')])[1]")
	WebElement eleCreditCardNum;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'select-date-1 month')]")
	WebElement eleCreditExpiryDate;
	@FindBy(how = How.XPATH, using = "(//*[contains(@class,'select-date-2 year')])[1]")
	WebElement eleCreditExpiryYear;
	@FindBy(how = How.XPATH, using = "(//*[contains(@name,'AccountHolderName')])[1]")
	WebElement eleCreditAccountName;
	@FindBy(how = How.XPATH, using = "(//*[contains(@name,'VerificationCode')])[1]")
	WebElement eleCreditCVVNUm;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'voucher')]")
	WebElement eleVoucher;
	@FindBy(how = How.XPATH, using = "//*[contains(@name,'TextBoxVoucherAccount_VO_ACCTNO')]")
	WebElement eleVoucherNum;
	@FindBy(how = How.XPATH, using = "//*[contains(@value,'Retrieve')]")
	WebElement eleRetrive;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'flight_total_detailseat centralize')]//following::label")
	WebElement eleTotalAmount;
	@FindBy(how = How.XPATH, using = "//a[contains(@id,'CONTROLGROUPPAYMENTBOTTOM')]")
	WebElement elepayNow;

	public JazeeraPaymentPage selectPaymentType(String paymentType, String cardType, String cardNum, String expiryDate,
			String expiryYer, String cardName, String cvvNum, String voucherData) throws Exception {
		System.out.println("Page Name: " + driver.getTitle());
		switch (paymentType) {
		case "KnetPayment":
			click(elekNet, "K-Net Payement");
			click(elepayNow, "Pay Now Button");
			break;

		case "CreditCard":
			click(eleCreditCard, "Credit card Payment");
			dropDown(eleCardType, cardType, "Card Type");
			clearAndType(eleCreditCardNum, cardNum, "Credit Card Number");
			dropDown(eleCreditExpiryDate, expiryDate, "Expiry Date");
			dropDown(eleCreditExpiryYear, expiryYer, "Expiry Year");
			clearAndType(eleCreditAccountName, cardName, "Card Holder Name");
			clearAndType(eleCreditCVVNUm, cvvNum, "CVV Filed");
			click(elepayNow, "Pay Now Button");
			break;

		case "Voucher":
			click(eleVoucher, "Voucher Payment");
			clearAndType(eleVoucherNum, voucherData, "Voucher Number");
			click(eleRetrive, "Retrive Button");

			break;
		}
		System.out.println("Total Amount in INR: " + eleTotalAmount.getText());

		FinalTotalAmount = eleTotalAmount.getText().replaceAll("\\D", "");
		return this;
	}

	public JazeeraPaymentPage fareCheck() throws Exception {

		System.out.println("fare check o/p for total fare: " + totalFair);
		System.out.println("fare check o/p for Final total fare: " + FinalTotalAmount);

		try {
			if (totalFair.equals(FinalTotalAmount)) {
				System.out.println("Total Amount Matched");
			} else {
				System.out.println("Total Amount Match failure");
			}

		} catch (Exception e) {
			System.err.println("Fare Check Methods Failure" + e);
			throw new Exception();
		}
		return this;
	}

}
