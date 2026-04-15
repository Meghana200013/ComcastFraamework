package com.vtiger.framework.generic.PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssertionForLead {
	
	public AssertionForLead(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerInfo;

	public String getHeaderInfo() {
		return headerInfo.getText();
	}
	
	
	

}
