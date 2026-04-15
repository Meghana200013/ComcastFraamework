package com.vtiger.framework.OrgTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.vtiger.framework.generic.PomUtility.CreateNewOrganizationPage;
import com.vtiger.framework.generic.PomUtility.HomePage;
import com.vtiger.framework.generic.PomUtility.LoginPage;
import com.vtiger.framework.generic.PomUtility.OrganizationPagePLUSE;
import com.vtiger.framework.generic.PomUtility.ValidationOFOrgCreatePage;
import com.vtiger.framework.generic.WebdriverUtility.JavaUtility;
import com.vtiger.framework.generic.fileutility.EcelUtility;
import com.vtiger.framework.generic.fileutility.FileUtility;

public class CreateOrgTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// read common data from properties file
		FileUtility fileUt = new FileUtility();

		String URL = fileUt.getDataFromPropertiesFile("url");
		String USERNAME = fileUt.getDataFromPropertiesFile("username");
		String PASSWORD = fileUt.getDataFromPropertiesFile("password");
		String BROWSER = fileUt.getDataFromPropertiesFile("browser");

		// generate the random number
		JavaUtility randomUt = new JavaUtility();

		// read testscipt data from Excel file
		EcelUtility excelUt = new EcelUtility();
		String OrgName = excelUt.getDataFromExcel("Org", 4, 2) + randomUt.getRandomNumber();
		String Industry = excelUt.getDataFromExcel("Org", 4, 3);
		String Type = excelUt.getDataFromExcel("Org", 4, 4);

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("forefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin","admin");

		// using pom
		HomePage obj = new HomePage(driver);
		obj.getOrglink().click();
		// obj.getContaclink().click();

		// to click on that org+button
		OrganizationPagePLUSE org = new OrganizationPagePLUSE(driver);
		org.getCreateNewOrgBn().click();

		// to add details to the org textfield
		/*
		 * CreateNewOrganizationPage details = new CreateNewOrganizationPage(driver);
		 * details.orgaDetails(OrgName);
		 */

		// to add details orgname industry
		CreateNewOrganizationPage details = new CreateNewOrganizationPage(driver);
		details.orgaDetails(OrgName, Industry);

		// validation of orgpage
		ValidationOFOrgCreatePage valid = new ValidationOFOrgCreatePage(driver);
		String actOrgName = valid.getValidationName().getText();
		
		if (actOrgName.contains(OrgName)) {
			System.out.println(OrgName + "name is verified ===Pass");
		} else {
			System.out.println(OrgName + "name is verified ===Fail");
		}

		obj.logout();

		driver.quit();

		// click on Org
//         		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
//         		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}

}
