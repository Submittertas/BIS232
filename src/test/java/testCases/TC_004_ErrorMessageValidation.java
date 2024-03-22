package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BISErrorValidation;
import pageObjects.BISHomePage;
import pageObjects.BISLoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_004_ErrorMessageValidation extends BaseClass {

	
	//(dataProvider="ErrorMessageForm", dataProviderClass = DataProviders.class)
	
	@Test(priority=1)
	public void loginValidation() throws InterruptedException
	{
		//Main Page Login
				logger.info("*** Starting Testcase*****");
				BISHomePage bhp = new BISHomePage(driver);
				bhp.clickLogin();
				logger.info("*** Login Page Should Display*****");
				
				
		//Page to Enter Credentials or Register
				BISLoginPage blp = new BISLoginPage(driver);
				logger.info("*** Enter Email *****");
				
		//		blp.setLoginEmail(p.getProperty("email"));
				
				logger.info("*** Enter Password *****");
				
		//		blp.setLoginPassword(p.getProperty("password"));
				
				blp.clickLoginButton();
				
				logger.info("*** Login Successful *****");
				
				Thread.sleep(3000);
				
				
				
	}
	
		// Call the Error Messages
		
	@Test(priority=2)
	public void emailFieldValidation()
	{			// Call The IsDisplayed Error Message from the BISErrorValidation POM
				BISErrorValidation bev = new BISErrorValidation(driver);
				bev.emailErrorMessage();
				
				// Call The Is Empty Method from the BISLoginPage POM
				BISLoginPage blp = new BISLoginPage(driver);
				blp.loginEmailEmpty();
				
				//Verify that if the Email field is empty, then capture the Error Message
				if(blp.loginEmailEmpty())
				{
				Assert.assertTrue(bev.emailErrorMessage());
				bev.emailErrorText();
				}
	}
		
	
	@Test(priority=3)
	public void passwordFieldValidation()
	{			
		
				// Call The IsDisplayed Error Message from the BISErrorValidation POM
				BISErrorValidation bev = new BISErrorValidation(driver);				
				bev.passwordErrorMessage();
				
				// Call The Is Empty Method from the BISLoginPage POM
				BISLoginPage blp = new BISLoginPage(driver);
				blp.loginPasswordEmpty();
				
				
				//Verify that if the Password field is empty, then capture the Error Message
				if(blp.loginPasswordEmpty())
				{
				Assert.assertTrue(bev.passwordErrorMessage());
				bev.passwordErrorText();
				}
	}			
				
				
				
				
				
				
				
			/*	String err1 = bev.emailErrorMessage();
				String expectedemailerror = "The Email field is required.";
				
				String err2 = bev.passwordErrorMessage();
				String expectedpassworderror = "The Password field is required.";
				
				if(expectedemailerror.equalsIgnoreCase(err1))
				{
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
				
				if(expectedpassworderror.equalsIgnoreCase(err2))
				{
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);	
				}
				
				
				
				
			/*	if(message.equalsIgnoreCase("The Email field is required."))
				{
					if(err1 == true)
					{
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				
					if(message.equalsIgnoreCase("The Password field is required."))
					{
					if(err2 == true)
						{
							Assert.assertTrue(true);
						}
					else
						{
							Assert.assertTrue(false);
						}
					
				}
				}
	}*/
}

				
				
				
				
				
			/*	String emailErrorMessage = driver.findElement(By.xpath("//*[@id=\"Input_Email-error\"]")).getText();
				String actualEmailErrorMessage = "The Email field is required.";
				String passwordErrorMessage = driver.findElement(By.xpath("//*[@id=\"Input_Password-error\"]")).getText();
				String actualPasswordErrorMessage = "The Password field is required.";
				
				
				Assert.assertEquals(actualEmailErrorMessage, emailErrorMessage, "Error Message Mismatch");
				Assert.assertEquals(actualPasswordErrorMessage, passwordErrorMessage, "Password Mismatch"); */

