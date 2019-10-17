package org.jazeera.utils;

import java.util.List;

import org.jazeera.commons.Jazeera_ProjectSpecificMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarHandling extends Jazeera_ProjectSpecificMethods{

	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	public void dateHandle(String year, String month, String date) {

		section: for (int i = 0; i <= 50; i++) {
			
			String cYear = driver.findElementByXPath("//*[contains(@class,'year')]").getText();

			if (cYear.equalsIgnoreCase(year)) {
				String cMonth = driver.findElementByXPath("//span[contains(@class,'month')]").getText();

				if (cMonth.equalsIgnoreCase(month)) {
					List<WebElement> cDate = driver.findElementsByXPath("//a[contains(@class,'ui-state-default')]");

					for (int j = 0; j <= cDate.size(); j++) {

						if (cDate.get(j).getText().equals(date)) {
							cDate.get(j).click();
							break section;
						}
					}
				}

				else {
					driver.findElementByXPath("(//*[contains(@class,'icon')])[2]").click();
				}
			}

			else {
				WebElement departCal = wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//*[contains(@class,'ui-datepicker-next')])")));
				departCal.click();
				//driver.findElementByXPath("(//*[contains(@class,'icon')])[2]").click();
			}

		}
	}

}
