package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility {//Rule 1 :Create a separate POM class for every web page
	
	//Rule 2 Identify webelement using FindBy
	
	@FindBy(linkText ="Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImagemouseover;
	
	@FindBy(linkText ="Sign Out")
	private WebElement Signout;
	
	
	//Rule 3 create constructor 
	
		


		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}


		public WebElement getContactlink() {
			return contactlink;
		}


		public WebElement getAdminImagemouseover() {
			return adminImagemouseover;
		}


		public WebElement getSignout() {
			return Signout;
		}


		public void ClickOnContactsLink()
		{
			contactlink.click();
			
		}
		public void logoutOfApp(WebDriver driver) throws Throwable
		{
			mouseOverAction(driver,adminImagemouseover);
			Thread.sleep(1000);
			Signout.click();
		}

}
