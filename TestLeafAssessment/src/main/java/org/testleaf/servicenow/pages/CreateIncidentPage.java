package org.testleaf.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testleaf.servicenow.utils.P_S_Methods;

public class CreateIncidentPage extends P_S_Methods {
	
	
	
	public CreateIncidentPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH, using="//input[@id='incident.number']")WebElement eleNewRecordNum;
	@FindBy(how=How.XPATH, using="//input[@id='sys_display.incident.caller_id']")WebElement eleCaller;
	@FindBy(how=How.XPATH, using="//input[@id='incident.short_description']")WebElement eleDescription;
	@FindBy(how=How.XPATH, using="(//button[@type='submit'])[3]")WebElement eleRecordSubmit;
	
	public CreateIncidentPage getIncidentNum() {
		driver.switchTo().frame(0);
		genIncidentNum = eleNewRecordNum.getAttribute("value");
		System.out.println("Generated Incident Number is:  "+genIncidentNum);
		return this;
	}
	
	public CreateIncidentPage enterCallerName(String callerName) throws InterruptedException {
		eleCaller.clear();
		Thread.sleep(5000);
		eleCaller.sendKeys(callerName);
		return this;
	}
	
	public CreateIncidentPage enterShortDescription(String StDescription) throws InterruptedException {
		eleDescription.sendKeys(StDescription);
		return this;
	}
	
	public IncidentRetrivePage clickRecordSubmit() throws InterruptedException {
		
		Thread.sleep(4000);
		WebElement submit = driver.findElementByXPath("(//button[@id='sysverb_insert'])[2]");
		new Actions(driver).click(submit).build().perform();
	//	submit.click();
		System.out.println("click worked");
		return new IncidentRetrivePage();
	}
	
	

	
}
