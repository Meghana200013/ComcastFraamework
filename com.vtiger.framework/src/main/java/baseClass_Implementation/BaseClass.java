package baseClass_Implementation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Parameters;
import com.vtiger.framework.generic.PomUtility.HomePage;
import com.vtiger.framework.generic.PomUtility.LoginPage;
import com.vtiger.framework.generic.WebdriverUtility.JavaUtility;
import com.vtiger.framework.generic.WebdriverUtility.WebDriverUtility;
import com.vtiger.framework.generic.fileutility.EcelUtility;
import com.vtiger.framework.generic.fileutility.FileUtility;

public class BaseClass {
	
	public FileUtility fileUt = new FileUtility();
	public WebDriverUtility WebUt = new WebDriverUtility();
	public EcelUtility eUT = new EcelUtility();
	public JavaUtility jUT = new JavaUtility();
	public EcelUtility excelUt = new EcelUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver;
	
    
	@BeforeSuite(alwaysRun = true)
	public void configBS() {
	
	}
     
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(String browser) throws Throwable {
		//String BROWSER=browser;
		String BROWSER = fileUt.getDataFromPropertiesFile("browser");
		
		//Read data from CMD line
		
		//String BROWSER=System.getProperty("browser", fileUt.getDataFromPropertiesFile("browser"));

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		 else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		String URL = fileUt.getDataFromPropertiesFile("url");
		//String URL=System.getProperty("url", fileUt.getDataFromPropertiesFile("url"));
		driver.get(URL);
		WebUt.waitForPageLoad(driver);
		driver.manage().window().maximize();
		
		/*----------Reading data from CMD Line-----------//
		String USERNAME = System.getProperty("userName", fileUt.getDataFromPropertiesFile("username"));
		String PASSWORD =System.getProperty("password", fileUt.getDataFromPropertiesFile("password"));*/
		
		String USERNAME = fileUt.getDataFromPropertiesFile("username");
		String PASSWORD = fileUt.getDataFromPropertiesFile("password");
		LoginPage lPage = new LoginPage(driver);
		lPage.loginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		HomePage Hpage = new HomePage(driver);
		Hpage.logout();

	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() {
		 
	}

}