package org.jazeera.testcases;

import org.jazeera.commons.Jazeera_ProjectSpecificMethods;
import org.jazeera.pages.JazeeraHomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class JZ_TC_OW extends Jazeera_ProjectSpecificMethods{
	
	@BeforeClass
	public void setData() {
		enterExcelName ="OneWayJazz";
	}

	@Test(dataProvider = "jazeeraDataBase")
	public void oneWayTC(String currency, String lang, String tripType, String fromCity, String toCity, String fmYear, String fmMonth, String fmDate, String adult, String child, String infant, String flexi) throws Exception {

		JazeeraHomePage jazz = new JazeeraHomePage();
		jazz.selectCurrency(currency)
		.selectLang(lang)
		.selectTripType(tripType)
		.flexiDate(flexi)
		.selectCityPair(fromCity, toCity)
		.departCalendar(fmYear, fmMonth, fmDate)
		.selectAdult(adult)
		.selectChild(child)
		.selectInfant(infant)
		.searchFlight()
		.selectFlight()
		.clickBookNow()
		.selectPassesngerTitle("Mr")
		.enterPassesngerFName("Test")
		.enterPassesngerLName("QA")
		.selectGender("Male")
		.selectcontactPassTitle("Mr")
		.entercontactPassFName("Mike")
		.entercontactPassLName("G")
		.enterConCity("Ahmedabad")
		.selectConCountry("India")
		.selectConCountryCode("India(91)")
		.enterConMobile("7548554872")
		.enterConEmail("test@mmail.com")
		.retainConDetails("RetainDataOFF")
		.getPromoUpdates("promoOFF")
		.submitPassengerDetails()
		.selectSeat("prioritySeat")
		.clickSeatContinue()
		.selectPaymentType("CreditCard", "Master Card", "123456478521456", "04", "2024", "Tester", "541", "4587711")
		.fareCheck();

	}
}
