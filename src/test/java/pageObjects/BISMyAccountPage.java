package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BISMyAccountPage extends BasePage{

	public BISMyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/h3")
	WebElement dashboardHeading;
	
	@FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/a")
	WebElement btnCreateNewER;
	
	@FindBy(xpath = "//*[@id=\"navbarDropdown\"]")
	WebElement navBar;
	
	@FindBy(xpath = "//*[@id=\"logoutForm\"]/ul/li/div/button/span")
	WebElement logout;
	
	public boolean dashboardisDisplayed()
	{
		try {
		return (dashboardHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;

		}
		
	}
	
	
	public void createNewER()
	{
		btnCreateNewER.click();
	}
	
	public void clickLogOut() throws InterruptedException
	{
		navBar.click();
		Thread.sleep(2000);
		logout.click();
	}
	
	

}
