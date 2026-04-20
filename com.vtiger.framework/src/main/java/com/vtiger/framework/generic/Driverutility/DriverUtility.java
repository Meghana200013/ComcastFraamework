package com.vtiger.framework.generic.Driverutility;

import org.openqa.selenium.WebDriver;

public class DriverUtility {
	
	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
	
	public static void setDriver(WebDriver driver)
	{
		tdriver.set(driver);
	}
	
	public static WebDriver getDriver()
	{
		return tdriver.get();
	}
	
	public static void unload()
	{
		tdriver.remove();
	}

}
