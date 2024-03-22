package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	
	// Actions/ Methods
	
	public void clickMyAccount()
	{
		linkMyAccount.click();
	}
	
	
	public void clickRegister()
	{
		linkRegister.click();
	}

}
