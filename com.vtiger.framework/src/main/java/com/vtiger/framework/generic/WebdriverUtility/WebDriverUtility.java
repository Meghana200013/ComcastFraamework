package com.vtiger.framework.generic.WebdriverUtility;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
    
    public void waitForPageLoad(WebDriver driver)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    
    public void waitForElementPresent(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
   
    // Switch to Child Window (for 2 windows only)
    public void switchNewBrowserTab(WebDriver driver)
    {
        String parentId = driver.getWindowHandle();
        Set<String> allIds = driver.getWindowHandles();

        for (String id : allIds) 
        {
            if (!id.equals(parentId)) 
            {
                driver.switchTo().window(id);
                break; 
            }
        }
    }

    // Get Parent Window ID (call BEFORE switching)
    public String getParentWindowId(WebDriver driver)
    {
        return driver.getWindowHandle();
    }

    // Switch back to Parent Window
    public void switchToParentWindow1(WebDriver driver, String parentId)
    {
        driver.switchTo().window(parentId); 
    }


    // Switch to window by title (for multiple windows)
    public void switchToWindowByTitle(WebDriver driver, String expectedTitle)
    {
        Set<String> allId = driver.getWindowHandles();

        for (String id : allId) 
        {
            driver.switchTo().window(id);

            if (driver.getTitle().contains(expectedTitle)) 
            {
                break;
            }
        }
    }

    // Switch back to Parent Window 
    public void switchToParentWindow(WebDriver driver, String parentId)
    {
        Set<String> allIds = driver.getWindowHandles();

        for (String id : allIds) 
        {
            if (id.equals(parentId)) 
            {
                driver.switchTo().window(id);
                break;
            }
        }
        
    }
    
    public void switchToFrame(WebDriver driver,int index) {
    	driver.switchTo().frame(index); 	
    }
    
    public void switchtoFrame(WebDriver driver,String nameId) {
    	driver.switchTo().frame(nameId);
    }
    	
    	 public void switchtoFrame(WebDriver driver,WebElement element) {
    	    	driver.switchTo().frame(element);
    }
    	 
    	 public void switchToAlertAccept(WebDriver driver)
    	 {
    		 driver.switchTo().alert().accept();
    	 }
    	 
    	 public void switchToAlertCancel(WebDriver driver)
    	 {
    		 driver.switchTo().alert().dismiss();
    	 }
    	 
    	 public void handleDropDown(WebElement element,String text)
    	 {
    		 Select s1= new Select(element);
    		 s1.selectByVisibleText(text);
    	 }
    	 
    	 public void select(WebElement element,int index)
    	 {
    		 Select s2 = new Select(element);
    		 s2.selectByIndex(index);
    	 }
    	 
    	 public void mouseHoveringActions(WebDriver driver,WebElement element)
    		{
    			Actions act = new Actions(driver);
    			act.moveToElement(element).perform();
    		}
    		
    	 public void doubleClickAction(WebDriver driver,WebElement element)
    		{
    			Actions act = new Actions(driver);
    			act.doubleClick(element).perform();
    		}
    	 
    	 public void rightClickAction(WebDriver driver,WebElement element)
    		{
    			Actions act = new Actions(driver);
    			act.contextClick(element).perform();
    		}
    	 
}
