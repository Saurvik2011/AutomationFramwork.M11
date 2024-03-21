package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule 1 :Create a separate POM class for every web page
	
	//Rule 2 Identify webelement using FindBy
	
	@FindBy(name ="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name ="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id ="submitbutton")
	private WebElement loginBtn;
	
	//Rule 3 create constructor 
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Rule 4 provide Getter
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//This business library specifically project
	
	public void LoginToApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	
	
}
