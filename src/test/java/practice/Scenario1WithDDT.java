package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1WithDDT {

	public static void main(String[] args) throws IOException, Throwable {
		/*Read Common Data -Properties File  */
		FileInputStream fisp =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p =new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		/*Read Test Data -Excel File  */
		FileInputStream fise =new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fise);
		String LASTNAME = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		//step 1 ############## Login to app with valid Credentials ##############
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(URL);
				driver.manage().window().maximize();
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//driver.manage().timeouts().implicitlyWait();
				Thread.sleep(3000);
				driver.findElement(By.id("submitButton")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//step 2################### Navigate to Contact link ################
				driver.findElement(By.linkText("Contacts")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				//step 3######################## Click on Create Contact Look up image ##############
				driver.findElement(By.xpath("//img[@alt=\"Create Contact...\"]")).click();
				Thread.sleep(3000);
				
				//step 4################## Create Contact with mandatory information ###############
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				Thread.sleep(3000);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("application logged out successfully");
				//############## close of browser ###############
				
				driver.quit();


	}

}
