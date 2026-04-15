package com.vtiger.framework.generic.PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.framework.generic.WebdriverUtility.WebDriverUtility;

public class LeadsPluse {
	WebDriver driver;
	public LeadsPluse(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement leadsPluse;
	
	@FindBy(name="lastname")
	private WebElement LastNameTF;
	

	@FindBy(name="company")
	private WebElement CompanyTF;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBn;
	
	@FindBy(name="leadsource")
	private WebElement dropDown;

	public WebElement getDropDown()
	{
		return dropDown;
	}
	
	public WebElement getLastName() {
		return LastNameTF;
	}
	
	public WebElement getCompany() {
		return CompanyTF;
	}
	
	public WebElement getLeadsPluse() {
		return leadsPluse;
	}
	public WebElement getSaveBn()
	{
		return SaveBn;
	}
	
	public void lastAndCompany(String LastName,String Company)
	{
		LastNameTF.sendKeys(LastName);
		CompanyTF.sendKeys(Company);
		//SaveBn.click();
	}
	
	
	public void selectLeadSource(WebDriverUtility wUtil, String source) {
	    wUtil.handleDropDown(dropDown, source);
	}

}
