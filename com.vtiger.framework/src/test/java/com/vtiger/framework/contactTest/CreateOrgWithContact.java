package com.vtiger.framework.contactTest;


import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.vtiger.framework.generic.WebdriverUtility.JavaUtility;
import com.vtiger.framework.generic.WebdriverUtility.WebDriverUtility;
import com.vtiger.framework.generic.fileutility.EcelUtility;
import com.vtiger.framework.generic.fileutility.FileUtility;

public class CreateOrgWithContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Integration testing
		FileUtility fileUt= new FileUtility();
		String URL = fileUt.getDataFromPropertiesFile("url");
        String USERNAME = fileUt.getDataFromPropertiesFile("username");
        String PASSWORD = fileUt.getDataFromPropertiesFile("password");
        String BROWSER = fileUt.getDataFromPropertiesFile("browser");

		// generate the random number
        JavaUtility randomUt = new JavaUtility();

		// read testscipt data from Excel file
		  EcelUtility excelUt = new EcelUtility();
		String OrgName = excelUt.getDataFromExcel("Contact", 7, 2)+randomUt.getRandomNumber();
		String LastName = excelUt.getDataFromExcel("Contact", 7, 3)+randomUt.getRandomNumber();
		

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		// click on save
		driver.findElement(By.id("submitButton")).click();
		
		//click on Org
 		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
 		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
 		
 		//read data from ecxcel file
 		driver.findElement(By.name("accountname")).sendKeys(OrgName);
 		
 		//save
 		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
 		 Thread.sleep(2000);

		// click on contac page
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		// Thread.sleep(2000);

		// click on that plue button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// to add last name
		driver.findElement(By.name("lastname")).sendKeys(LastName);

		// to click that extra pluse
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();

		// switch to child winmdow
		WebDriverUtility webUt = new WebDriverUtility();

		// Step 1: store parent
		String parentId = webUt.getParentWindowId(driver);

		// Step 2: click (opens child)

		// Step 3: switch to child
		webUt.switchNewBrowserTab(driver);

		// do actions in child

		

		driver.findElement(By.id("search_txt")).sendKeys(OrgName);
		driver.findElement(By.name("search")).click();
			
		driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click();

		// Step 4: switch back to parent
				webUt.switchToParentWindow(driver, parentId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.quit();

	}

}
