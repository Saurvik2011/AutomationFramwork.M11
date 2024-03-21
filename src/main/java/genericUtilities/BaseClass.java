package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public ExcelFileUtility eUtil =new ExcelFileUtility();
	public PropertyFileUtility pUtil =new PropertyFileUtility();
	public SeleniumUtility sUtil =new SeleniumUtility();
	public WebDriver driver;
	
	//For Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("DB connection successful");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws Throwable
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		//driver=new ChromeDriver();
//		if(BROWSER.equalsIgnoreCase("Chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if (BROWSER.equalsIgnoreCase("Firefox"))
//		{
			WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
//		
		
		sUtil.maximizewindow(driver);
		sUtil.addImplicitlywait(driver);
				driver.get(URL);
				
				//for Listeners
				sdriver=driver;
				System.out.println("Browser launching Application successful");
					
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws Throwable
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp =new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("Login to app is successfull");
	}
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws Throwable

	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("Logout to app is successfull");
	}
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("Browser cloasure is successfull");
	}
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("DB closure successful");
	}
}
