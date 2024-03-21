package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//step 1 ############## Login to app with valid Credentials ##############
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().implicitlyWait();
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 2################### Navigate to Products link ################
		driver.findElement(By.linkText("Products")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//step 3######################## Click on Create Contact Look up image ##############
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		Thread.sleep(3000);
		
		//step 4################## Create Contact with mandatory information ###############
		driver.findElement(By.name("productname")).sendKeys("abc");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		// step 5 ################ Verify for contact ##############
		
		 String productheader = driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]")).getText();
		 System.out.println(productheader);
		 
		 if (productheader.contains("abc"))
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


