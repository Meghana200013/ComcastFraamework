package com.vtiger.framework.generic.PomUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPluse {
	WebDriver driver;
	public ProductPluse(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement productPluse;
	
	@FindBy(name="productname")
	private WebElement productNameTF;
	
	@FindBy(name="vendor_name")
	private WebElement vendorNameTF;
	


	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getVendorName() {
		return vendorNameTF;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBN;

	public WebElement getProductNameTF() {
		return productNameTF;
	}

	public WebElement getSaveBN() {
		return saveBN;
	}

	public WebElement getProductName() {
		return productNameTF;
	}

	public WebElement getProductPluse() {
		return productPluse;
	}

	public void ProductDetails(String ProductName)
	{
		productNameTF.sendKeys(ProductName);
		saveBN.click();	}
	
	public void ProductDetails(String ProductName,String vendorName)
	
	{
		vendorNameTF.sendKeys(vendorName);
		productNameTF.sendKeys(ProductName);
		saveBN.click();
		
	}

	

}
