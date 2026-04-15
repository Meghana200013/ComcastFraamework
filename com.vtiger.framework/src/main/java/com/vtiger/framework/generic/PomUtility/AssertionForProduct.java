package com.vtiger.framework.generic.PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssertionForProduct {
	
	public AssertionForProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(className="lvtHeaderText")
	private WebElement headerInfo;
	
	@FindBy(id="dtlview_Product Name")
	private WebElement productname;
	

	public String getProductname() {
		return productname.getText();
	}


	public String  getHeaderInfo() {
		return headerInfo.getText();
	}
	
	

}
