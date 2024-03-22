package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BISHomePage extends BasePage {

	
	WebDriver driver;
	
	public BISHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
		@FindBy(xpath = "/html/body/nav/div/ul[2]/li[2]/ul/li/a/span")
		WebElement btnLogin;
		
	
		public void clickLogin()
		{
			btnLogin.click();
		}
	

}
