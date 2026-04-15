package com.vtiger.framework.generic.PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPagePLUSE {
	
	public OrganizationPagePLUSE(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgBn;

	public WebElement getCreateNewOrgBn() {
		return createNewOrgBn;
	}
	
	

}
