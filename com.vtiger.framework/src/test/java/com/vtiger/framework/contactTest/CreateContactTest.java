package com.vtiger.framework.contactTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.framework.generic.WebdriverUtility.JavaUtility;
import com.vtiger.framework.generic.fileutility.EcelUtility;
import com.vtiger.framework.generic.fileutility.FileUtility;

public class CreateContactTest {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileUtility fileUt= new FileUtility();
		
			        String URL =fileUt.getDataFromPropertiesFile("url");
			        String USERNAME = fileUt.getDataFromPropertiesFile("username");
			        String PASSWORD = fileUt.getDataFromPropertiesFile("password");
			        String BROWSER = fileUt.getDataFromPropertiesFile("browser");
			       
			        //generate the random number
			        JavaUtility randomUt = new JavaUtility();
			        
			      EcelUtility excelUt = new EcelUtility();
			      String LastName= excelUt.getDataFromExcel("Contact", 4, 2)+randomUt.getRandomNumber();
			                  
			                 WebDriver driver=null;
			                 if(BROWSER.equals("chrome"))
			                 {
			                	 driver=new ChromeDriver();
			                 }
			                 else if(BROWSER.equals("edge"))
			                 {
			                	 driver = new EdgeDriver();
			                 }
			                 else if(BROWSER.equals("firefox"))
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
			         		
			         		//click on contac page
			         		driver.findElement(By.xpath("(//a[text()='Contacts'])[1]")).click();
			         		//Thread.sleep(2000);
			         		
			         		//click on that plue button
			         		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			         		
			         		//to add last name
			         		driver.findElement(By.name("lastname")).sendKeys(LastName);
			         		
			         		//to save
			         		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			         		
			         		driver.quit();

}
}
