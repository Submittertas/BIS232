package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement textFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement textLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement textEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement textPassword;
	
	@FindBy(xpath = "//input[@id='input-newsletter-yes']")
	WebElement checkNewsletter;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkAgreement;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		textFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		textLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		textEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	public void checkNewsletter()
	{
		checkNewsletter.click();
	}
	
	public void checkAgreement()
	{
		checkAgreement.click();
	}
	
	public void btnContinue()
	{
		btnContinue.click();
		
		//sol2 
		//btnContinue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", btnContinue);
		
		//Sol 5
		//btnContinue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();

	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
	

}
