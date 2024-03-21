package practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class Scenario1WithDDTandGU {

	public static void main(String[] args) throws Throwable {
		ExcelFileUtility eUtil =new ExcelFileUtility();
		PropertyFileUtility pUtil =new PropertyFileUtility();
		SeleniumUtility sUtil =new SeleniumUtility();
		
		/*Read Common Data -Properties File  */
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		/*Read Test Data -Excel File  */
		FileInputStream fise =new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts",1,2);
		//step 1 ############## Login to app with valid Credentials ##############
		WebDriver driver =new ChromeDriver();
		sUtil.maximizewindow(driver);
		sUtil.addImplicitlywait(driver);
				driver.get(URL);
				driver.manage().window().maximize();
			//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			//  driver.findElement(By.id("submitButton")).click();	
				
				LoginPage lp =new LoginPage(driver);
				//lp.getUserNameEdt();
				//lp.getPasswordEdt();
				//lp.getLoginBtn();
				lp.LoginToApp(USERNAME, PASSWORD);
				Thread.sleep(3000);
				
				sUtil.addImplicitlywait(driver);
				
				//step 2################### Navigate to Contact link ################
				//ContactLinkPage lp =new LoginPage(driver);
				//driver.findElement(By.linkText("Contacts")).click();
				HomePage hp = new HomePage(driver);
			
				
				
				
				//step 3######################## Click on Create Contact Look up image ##############
				driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
				Thread.sleep(3000);
				
				//step 4################## Create Contact with mandatory information ###############
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				sUtil.addImplicitlywait(driver);
				driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
				// step 5 ################ Verify for contact ##############
				
				 String contactheader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
				 System.out.println(contactheader);
				 
				 if (contactheader.contains(LASTNAME))
				 {
					 System.out.println("PASS");
				 }
				 else
				 {
					 System.out.println("FAIL");
					 driver.close();
				 }
				 /*
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
						boolean getText =driver.findElement(By.className("detailedViewTextBox")).isDisplayed();
						System.out.println(getText);
				driver.findElement(By.name("button")).click();
				Thread.sleep(3000);
				*/
				
				//############## Logout of App ###############
				WebElement ele = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
				sUtil.mouseOverAction(driver, ele);
				Thread.sleep(3000);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("application logged out successfully");
				//############## close of browser ###############
				
				driver.quit();


	}

}
