package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups = {"regression", "master"})
	public void verify_Account_Creation() throws InterruptedException
	{
		
		logger.info("**** Starting Account Registration Test Case*****");
		try
		{

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		Thread.sleep(3000);
		hp.clickRegister();
		Thread.sleep(3000);
		
		logger.info("**** Entering Customer Details*****");
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString() + "@gmail.com");
		
		String password = randomAlphaNumeric();
		
		arp.setPassword(password);
		arp.checkNewsletter();
		arp.checkAgreement();
		arp.btnContinue();
		logger.info("**** Clicked on Continue*****");
		
		Thread.sleep(5000);
		
		String confmsg = arp.getConfirmationMsg();
		//(confmsg, "Your Account Has Been Created!");
		logger.info("**** Validating expected Message*****");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Message Fail");
			Assert.fail();
		}
		
		Thread.sleep(5000);
	}
	
}
