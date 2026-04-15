package com.vtiger.framework.generic.PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	WebElement orgNameTF;
	
	@FindBy(name="industry")
	WebElement industryDW;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	WebElement saveBN;

	public WebElement getOrgNameTF() {
		return orgNameTF;
	}

	public WebElement getSaveBN() {
		return saveBN;
	}
	
	public WebElement getindustryDW() {
		return industryDW;
	}
	
	public void orgaDetails(String OrgName)
	{
		orgNameTF.sendKeys(OrgName);
		saveBN.click();
	}
	public void orgaDetails(String OrgName,String Industry )
	{
		orgNameTF.sendKeys(OrgName);
		Select s = new Select(industryDW);
		s.selectByVisibleText(Industry);
		saveBN.click();
	}

}
