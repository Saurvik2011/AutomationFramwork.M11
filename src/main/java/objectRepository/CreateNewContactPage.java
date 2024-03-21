package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;
import io.netty.channel.MessageSizeEstimator.Handle;

public class CreateNewContactPage extends SeleniumUtility {
	
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement savebtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	


	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}


	public WebElement CreatLeadSourceDropDown() {
		return leadSourceDropDown;
	}
	public void createNewContact(String LASTNAME)
	{
		lastnameEdt.sendKeys(LASTNAME);
		savebtn.click();
	}
	public void createNewContact(String LASTNAME,String LEADSOURCE)
	{
		lastnameEdt.sendKeys(LASTNAME);
		handledropdown(leadSourceDropDown,LEADSOURCE);
		savebtn.click();
	}


	


}
