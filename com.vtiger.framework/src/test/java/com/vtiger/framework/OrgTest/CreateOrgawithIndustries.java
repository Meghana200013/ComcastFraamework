package com.vtiger.framework.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.framework.generic.WebdriverUtility.JavaUtility;
import com.vtiger.framework.generic.fileutility.EcelUtility;
import com.vtiger.framework.generic.fileutility.FileUtility;

public class CreateOrgawithIndustries {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//read common data from properties file
		FileUtility fileUt= new FileUtility();
		
        String URL =fileUt.getDataFromPropertiesFile("url");
        String USERNAME = fileUt.getDataFromPropertiesFile("username");
        String PASSWORD = fileUt.getDataFromPropertiesFile("password");
        String BROWSER = fileUt.getDataFromPropertiesFile("browser");
        
        //generate the random number
        JavaUtility randomUt = new JavaUtility();
        
        //read testscipt data from Excel file
        EcelUtility excelUt = new EcelUtility();
                String OrgName= excelUt.getDataFromExcel("Org", 4, 2)+randomUt.getRandomNumber();
                String Industry= excelUt.getDataFromExcel("Org", 4, 3);
                String Type= excelUt.getDataFromExcel("Org", 4, 4);
               
                 System.out.println(Industry);
                 System.out.println(Type);
                 System.out.println(OrgName);
                  
                 WebDriver driver=null;
                 if(BROWSER.equals("chrome"))
                 {
                	 driver=new ChromeDriver();
                 }
                 else if(BROWSER.equals("edge"))
                 {
                	 driver = new EdgeDriver();
                 }
                 else if(BROWSER.equals("forefox"))
                 {
                	 driver=new FirefoxDriver();
                 }
                 else
                 {
                	 driver=new ChromeDriver();
                 }
                 
                 driver.get(URL);
         		driver.manage().window().maximize();
         		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
         		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
         		
         		//click on save
         		driver.findElement(By.id("submitButton")).click();
         		
         		//click on Org
         		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
         		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
         		
         		//read data from ecxcel file
         		driver.findElement(By.name("accountname")).sendKeys(OrgName);
         		
         		//industries dropdown
         		WebElement indus = driver.findElement(By.name("industry"));
         		Select s = new Select(indus);
        		     s.selectByValue(Industry);
        		     
        		     //Type dropdown
        		     WebElement type = driver.findElement(By.name("accounttype"));
        				Select s1 = new Select(type);
        				s1.selectByValue(Type);
        				
         		//save the details
         		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
         		
         		//verify the Energy DropDown
         		String energyeEle = driver.findElement(By.id("dtlview_Industry")).getText();
         		if(energyeEle.equals(Industry))
         		{
         			System.out.println(Industry +"is created===>pass");
         		}
         		else
         		{
         			System.out.println(Industry +"is not created===>fail");
         		}
         		
         		String typeEle = driver.findElement(By.id("dtlview_Type")).getText();
         		if(typeEle.equals(Type))
         		{
         			System.out.println(Type +"is created===>pass");
         		}
         		else
         		{
         			System.out.println(Type +"is not created===>fail");
         		}
         		
         		driver.quit();
         		
         		
         		

         		
                 
                 
  
  

	}

	
	}



		
	


