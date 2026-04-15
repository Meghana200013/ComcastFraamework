package com.vtiger.framework.generic.PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPluse {
	
	public ContactPluse(WebDriver driver)
	{
	
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	WebElement contacPluse;

	public WebElement getContacPluse() {
		return contacPluse;
	}
	
	
	

}
