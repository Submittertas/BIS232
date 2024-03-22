package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BISRegisterButton extends BasePage{

	public BISRegisterButton(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div/section/form/div[5]/p[2]/a")
	WebElement btnRegister;
	
	public void clickRegisterButton()
	{
		btnRegister.click();
	}

}
