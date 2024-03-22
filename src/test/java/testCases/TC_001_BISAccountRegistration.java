package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BISAccountRegistration;
import pageObjects.BISHomePage;
import pageObjects.BISRegisterButton;
import testBase.BaseClass;

public class TC_001_BISAccountRegistration extends BaseClass {
	
	

	@Test(groups = {"regression", "master"})
	public void registration() throws InterruptedException
	{
		logger.info("**** Starting Account Registration Test Case*****");
		try
		{
		
		BISHomePage bhp = new BISHomePage(driver);
		bhp.clickLogin();
		
		Thread.sleep(4000);
		
		BISRegisterButton brb = new BISRegisterButton(driver);
		brb.clickRegisterButton();
		logger.info("**** Click Registration button*****");
		Thread.sleep(4000);
		
		BISAccountRegistration bar = new BISAccountRegistration(driver);
		//bar.setEmail(p.getProperty("email"));
		bar.setEmail(randomString() + "@gmail.com");
		
		// Set the Passwords the same
		String password = randomAlphaNumeric();
				
		bar.setPassword(password);
		bar.confirmPassword(password);
		
		//bar.setPassword(p.getProperty("password"));
		//bar.confirmPassword(p.getProperty("password"));
		
		bar.registerButton();
		logger.info("**** User Registers*****");
		
		
		String confirmmsg = bar.getConfirmationMsg();
		Assert.assertEquals(confirmmsg, "Registration Confirmation");
		}
		
		catch(Exception e)
		{
			logger.info("**** Message not displayed*****");
			Assert.fail();
		}
	}
	
	
	
}
