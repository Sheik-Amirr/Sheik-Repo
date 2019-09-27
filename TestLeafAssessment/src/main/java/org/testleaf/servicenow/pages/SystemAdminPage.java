package org.testleaf.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testleaf.servicenow.utils.P_S_Methods;

public class SystemAdminPage extends P_S_Methods{

	public SystemAdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='filter']")WebElement elefliter;
	@FindBy(how=How.XPATH, using="(//*[contains(text(),'Create New')])[1]")WebElement eleCreateNew;
	
	public SystemAdminPage enterFilterData(String filterData) throws InterruptedException {
		elefliter.sendKeys(filterData);
		Thread.sleep(3000);
		return this;
	}
	
	public CreateIncidentPage clickCreateNew() {
		eleCreateNew.click();
		return new CreateIncidentPage();
	}
	
	
	
	
	
	
	
}