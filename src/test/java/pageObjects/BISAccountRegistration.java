package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BISAccountRegistration extends BasePage {

	public BISAccountRegistration(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='Input_Email']")
	WebElement textEmail;
	
	@FindBy(xpath = "//input[@id='Input_Password']")
	WebElement textPassword;
	
	@FindBy(xpath = "//input[@id='Input_ConfirmPassword']")
	WebElement textConfirmPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnRegister;
	
	@FindBy(xpath = "//h2[normalize-space()='Registration Confirmation']")
	WebElement msgConfirmation;
	
	
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	

	public void setPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	

	public void confirmPassword(String confirmpassword)
	{
		textConfirmPassword.sendKeys(confirmpassword);
	}
	
	public void registerButton()
	{
		btnRegister.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
		
	}
	
	

}
