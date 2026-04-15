package practic_BaseClass_Program;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.framework.generic.PomUtility.ContactPluse;
import com.vtiger.framework.generic.PomUtility.HomePage;
import com.vtiger.framework.generic.PomUtility.OrganizationPagePLUSE;
import com.vtiger.framework.generic.WebdriverUtility.JavaUtility;
import com.vtiger.framework.generic.WebdriverUtility.WebDriverUtility;

import baseClass_Implementation.BaseClass;

public class CreateContactBase extends BaseClass {
	public JavaUtility randomUt = new JavaUtility(); 
	public WebDriverUtility webUt = new WebDriverUtility();
		@Test
     public void mainTest() throws Throwable, IOException {
		int randomNumber = randomUt.getRandomNumber();
		
	 String LastName= excelUt.getDataFromExcel("Contact", 4, 2)+randomNumber;
	 System.out.println(LastName);
	 
	 HomePage Hpage = new HomePage(driver);
	 Hpage.getContaclink().click();
	 
	 ContactPluse Pluse = new ContactPluse(driver);
	 Pluse.getContacPluse().click();
	 
	 driver.findElement(By.name("lastname")).sendKeys(LastName);
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 
	}
	
	@Test
	public void contactWithDate() throws Throwable, IOException
	{
		int randomNumber = randomUt.getRandomNumber();
		 String LastName= excelUt.getDataFromExcel("Contact", 4, 2)+randomNumber;
		 
		 HomePage Hpage = new HomePage(driver);
		 Hpage.getContaclink().click();
			
		 ContactPluse Pluse = new ContactPluse(driver);
		 Pluse.getContacPluse().click();
		 
		 driver.findElement(By.name("lastname")).sendKeys(LastName);
		 
		 JavaUtility dateUt = new JavaUtility();
  		String Stratdate = dateUt.getSystemDate();
  		
  		JavaUtility dateUt1 = new JavaUtility();
  		String Enddate = dateUt1.getRequiredDate(30);
  		System.out.println(Stratdate);
  		System.out.println(Enddate);
  		
 		driver.findElement(By.name("support_start_date")).clear();
 		driver.findElement(By.name("support_start_date")).sendKeys(Stratdate);
 		
	driver.findElement(By.name("support_end_date")).clear();
	driver.findElement(By.name("support_end_date")).sendKeys(Enddate);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	//validation for start date
 	/*String actulstartDate = driver.findElement(By.name("support_start_date")).getText();
 	if(Stratdate.equals(actulstartDate))
 	{
 		System.out.println("Start date is pass");
 	}
 	else
 	{
 		System.out.println("strat date is fail");
 	}
 	
 	//validation for End date
 	String actulend = driver.findElement(By.name("support_end_date")).getText();
 	if(Enddate.equals(actulend))
 	{
 		System.out.println("End date is pass");
 		
 	}
 	else 
 	{
 		System.out.println("End date is fail");
 	}
		 
	}*/
	
	@Test
	public void orgWithCpntact() throws Throwable, IOException
	{
		int randomNumber = randomUt.getRandomNumber();
		String OrgName = excelUt.getDataFromExcel("Contact", 7, 2)+randomNumber;
		String LastName = excelUt.getDataFromExcel("Contact", 7, 3)+randomNumber;
		
		HomePage page = new HomePage(driver);
		page.getOrglink().click();
		
		OrganizationPagePLUSE Pluse = new OrganizationPagePLUSE(driver);
		Pluse.getCreateNewOrgBn().click();
		 
		 driver.findElement(By.name("accountname")).sendKeys(OrgName);
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 		 Thread.sleep(2000);
 		 
 		 HomePage Hpage = new HomePage(driver);
		 Hpage.getContaclink().click();
			
		 ContactPluse cPluse = new ContactPluse(driver);
		 cPluse.getContacPluse().click();
		 
		 driver.findElement(By.name("lastname")).sendKeys(LastName);
		 driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		 String parentId = webUt.getParentWindowId(driver);
		 webUt.switchNewBrowserTab(driver);
		 
		 driver.findElement(By.id("search_txt")).sendKeys(OrgName);
			driver.findElement(By.name("search")).click();
				
			driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click();
			
			webUt.getParentWindowId(driver);

			// Step 4: switch back to parent
					webUt.switchToParentWindow(driver, parentId);

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
 		 
 		 
	}
	 
}

    