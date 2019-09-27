package org.testleaf.servicenow.testcases;

import org.openqa.selenium.Keys;
import org.testleaf.servicenow.pages.LoginPage;
import org.testleaf.servicenow.utils.P_S_Methods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SN_TC_01 extends P_S_Methods {
	
	@BeforeClass
	public void setData() {
		enterExcelName ="ServiceNow";
	}

	@Test(dataProvider="serviceNowDB")
	public void ServiceNowTestcase(String userName, String password, String filterData, String callerName, String stDescription) throws InterruptedException {
		LoginPage SN = new LoginPage();
		SN.enterUserName(userName)
		.enterPassword(password)
		.enterFilterData(filterData)
		.clickCreateNew()
		.getIncidentNum()
		.enterCallerName(callerName+Keys.TAB)
		.enterShortDescription(stDescription)
		.clickRecordSubmit()
		.searchIncidentNum()
		.incidentCrossCheck();
		

	}
}