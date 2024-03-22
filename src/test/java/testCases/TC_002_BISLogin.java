package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BISHomePage;
import pageObjects.BISLoginPage;
import pageObjects.BISMyAccountPage;
import testBase.BaseClass;

public class TC_002_BISLogin extends BaseClass{
	
	@Test(priority = 1, groups = {"regression", "master"})
	public void login() throws InterruptedException
	{
		//Main Page Login
		logger.info("*** Starting Testcase*****");
		BISHomePage bhp = new BISHomePage(driver);
		bhp.clickLogin();
		logger.info("*** Login Page Should Display*****");
		
		
		//Page to Enter Credentials or Register
		BISLoginPage blp = new BISLoginPage(driver);
		logger.info("*** Enter Email *****");
		blp.setLoginEmail(p.getProperty("email"));
		
		logger.info("*** Enter Password *****");
		blp.setLoginPassword(p.getProperty("password"));
		blp.clickLoginButton();
		logger.info("*** Login Successful *****");
		
		Thread.sleep(3000);
		
		}
	
	@Test(priority = 2, groups = {"regression", "master"})
	public void verifyHomepage() throws InterruptedException
	{
		BISMyAccountPage bmap = new BISMyAccountPage(driver);
		boolean targetpage = bmap.dashboardisDisplayed();
		
		if(targetpage== true)
		{
			logger.info("*** dashboard is present *****");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("*** dashboard is not present *****");
			Assert.fail();
		}
		
		Thread.sleep(5000);
	}
		
	@Test(priority = 3, groups = {"sanity", "master"})
	public void logout() throws InterruptedException
	{
		logger.info("*** logging out *****");
		
		BISMyAccountPage bmap = new BISMyAccountPage(driver);
		bmap.clickLogOut();
	}
		

}
