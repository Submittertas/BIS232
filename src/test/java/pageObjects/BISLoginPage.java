package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BISLoginPage extends BasePage{

	public BISLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='Input_Email']")
	WebElement textEmail;
	
	@FindBy(xpath = "//input[@id='Input_Password']")
	WebElement textPassword;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/section/form/div[4]/button")
	WebElement btnLogin;
	
	
	public void setLoginEmail(String loginemail)
	{
		textEmail.sendKeys(loginemail);
		
	}
	
	public void setLoginPassword(String loginpassword)
	{
		textPassword.sendKeys(loginpassword);
	}
	
	public boolean loginEmailEmpty()
	{
		return textEmail.getAttribute("value").isEmpty();
	}
	
	public boolean loginPasswordEmpty()
	{
		return textPassword.getAttribute("value").isEmpty();
	}
	
	public void clickLoginButton()
	{
		btnLogin.click();
	}
	
}
