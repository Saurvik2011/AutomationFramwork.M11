package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@alt=\"Create Contact...\"]")
	private WebElement createconatctlookupumg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
public void clickOnCreateContactLookUpImg()
{
	createconatctlookupumg.click();
}
}
