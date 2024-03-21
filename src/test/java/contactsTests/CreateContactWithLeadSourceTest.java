package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

public class CreateContactWithLeadSourceTest extends BaseClass {

	
	@Test(groups="RegressionSuite")
	public void createContactWithLeadsource()  throws Throwable
	{
		
		
		
		/*Read Test Data -Excel File  */
		Thread.sleep(6000);
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts",4,2);
		Thread.sleep(6000);
		String LEADSOURCE = eUtil.readDataFromExcelFile("Contacts",4,3);
		
		//step 2################### Navigate to Contact link ################
		
		HomePage hp = new HomePage(driver);
	hp.ClickOnContactsLink();
				
			
				
				
				//step 3######################## Click on Create Contact Look up image ##############
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				//step 4################## Create Contact with mandatory information ###############
				CreateNewContactPage cncp = new CreateNewContactPage(driver);
				
				cncp.createNewContact(LASTNAME, LEADSOURCE);
				
				// step 5 ################ Verify for contact ##############
				
				 ContactInfoPage cip = new ContactInfoPage(driver);
				 String contactheader =cip.captureContactHeader();
				 
				 
				 Assert.assertTrue(contactheader.contains(LASTNAME));
				 System.out.println(contactheader);
				
				


	}


	}


