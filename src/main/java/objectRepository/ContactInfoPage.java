package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class ContactInfoPage  {
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement ContactHeaderText;
	
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	




	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}
	
	public String captureContactHeader()
	{
	return 	ContactHeaderText.getText();
	}





	


	

	



}
