package org.testleaf.servicenow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testleaf.servicenow.utils.P_S_Methods;

public class LoginPage extends P_S_Methods{

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="(//*[contains(@id,'user_name')])[1]")WebElement eleUserName;
	@FindBy(how=How.XPATH, using="(//*[contains(@id,'user_password')])[1]")WebElement elePassword;
	//@FindBy(how=How.XPATH, using="//*[contains(@id,'sysverb_login')]")WebElement elesubmit;
	
	public LoginPage enterUserName(String username) {
		driver.switchTo().frame(0);
		eleUserName.sendKeys(username);
		return this;
	}
	
	public SystemAdminPage enterPassword(String password) {
		elePassword.sendKeys(password, Keys.ENTER);
		return new SystemAdminPage();
	}
	
	/*public HomePage clickSubmit() {
		elesubmit.click();
		return this;
	}*/
}