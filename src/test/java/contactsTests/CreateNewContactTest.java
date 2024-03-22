package contactsTests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplimentation.class)
public class CreateNewContactTest extends BaseClass {

	
	

	@Test(groups="SmokeSuite")
	public void createNewContact() throws Throwable
	 {
		
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts",1,2);
		
		
				
				//step 2################### Navigate to Contact link ################
				
				HomePage hp = new HomePage(driver);
			hp.ClickOnContactsLink();
				
				
				
				//step 3######################## Click on Create Contact Look up image ##############
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				//step 4################## Create Contact with mandatory information ###############
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				
				cncp.createNewContact(LASTNAME);
				//Assert.fail();
				// step 5 ################ Verify for contact ##############
				
				 ContactInfoPage cip = new ContactInfoPage(driver);
				 Thread.sleep(6000);
				 String contactHeader = cip.captureContactHeader();
				 Thread.sleep(3000);
				 System.out.println(contactHeader);
				 Thread.sleep(3000);
 				 Assert.assertTrue(contactHeader.contains(LASTNAME));
				 System.out.println(contactHeader);
				


	}
	@Test
	public void sample()
	{
		System.out.println("Demo");
	}


	}


