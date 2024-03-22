package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BISErrorValidation extends BasePage {

	public BISErrorValidation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath= "//span[@id='Input_Email-error']")
	WebElement emailError;
	
	@FindBy(xpath= "//span[@id='Input_Password-error']")
	WebElement passwordError;
	
	
	
	public boolean emailErrorMessage()
	{
		return emailError.isDisplayed();
	}
	
	public void emailErrorText()
	{
		emailError.getText();
	}
	
	public boolean passwordErrorMessage()
	{
		return passwordError.isDisplayed();
	}
	
	public void passwordErrorText()
	{
		passwordError.getText();
	}
}
