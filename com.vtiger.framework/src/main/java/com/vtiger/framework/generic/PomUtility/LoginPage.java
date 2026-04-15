package com.vtiger.framework.generic.PomUtility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	WebDriver driver = null;
	
	public LoginPage(WebDriver driver ) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}

	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginBN;
	
	

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBN() {
		return loginBN;
	}
	
	//provide action (business Method)(specific to buisness)
	public void loginToApp(String UserName,String Password)
	{
		usernameTF.sendKeys(UserName);
		passwordTF.sendKeys(Password);
		loginBN.click();
		
	}
	
	
	
	

}
