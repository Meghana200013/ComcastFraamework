package com.vtiger.framework.OrgTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
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

import com.vtiger.framework.generic.WebdriverUtility.JavaUtility;
import com.vtiger.framework.generic.fileutility.EcelUtility;
import com.vtiger.framework.generic.fileutility.FileUtility;

public class CreateOrgWithPhoneNumber {

	public static void main(String[] args) throws IOException {
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
        String OrgName= excelUt.getDataFromExcel("Org", 7, 2)+randomUt.getRandomNumber();
         String phoneNum  = excelUt.getDataFromExcel("Org", 7, 3);
                  
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
         		
         		//read phone ftom ecxel file
         		  driver.findElement(By.id("phone")).sendKeys(phoneNum);
         		  
         		//save
         		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
         		
         		//validation for phone number
         		String phoneText = driver.findElement(By.id("dtlview_Phone")).getText();
         		if(phoneText.equals(phoneNum))
         		{
         			System.out.println(phoneText + "phone info is created===>pass");
         		}
         		else
         		{
         			System.out.println(phoneText + " phone info is not created===>fail");
         		}
	}

}
