package com.vtiger.framework.generic.PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contaclink;
	
	@FindBy(linkText="Product")
	private WebElement productlink;
	
	
	@FindBy(xpath="//a[@href='index.php?module=Products&action=index']")
	private WebElement productLink;
	
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOut;
	
	
	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContaclink() {
		return contaclink;
	}
	
	public WebElement getAdminImg()
	{
		return adminImg;
	}
   
	public void logout()
	{
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOut.click();
		
	}
	
	
	
	
	
	

}
