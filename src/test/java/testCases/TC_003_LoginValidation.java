package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BISHomePage;
import pageObjects.BISLoginPage;
import pageObjects.BISMyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginValidation extends BaseClass{
	
	
	@Test (dataProvider="BIS_LoginData", groups = {"master", "sanity"}, dataProviderClass = DataProviders.class)
	public void loginValidation(String email, String password, String res) throws InterruptedException
	{
		//Main Page Login
				logger.info("*** Starting Testcase*****");
				BISHomePage bhp = new BISHomePage(driver);
				bhp.clickLogin();
				logger.info("*** Login Page Should Display*****");
				
				
		//Page to Enter Credentials or Register
				BISLoginPage blp = new BISLoginPage(driver);
				logger.info("*** Enter Email *****");
				blp.setLoginEmail(email);
				
				logger.info("*** Enter Password *****");
				blp.setLoginPassword(password);
				blp.clickLoginButton();
				logger.info("*** Login Successful *****");
				
				Thread.sleep(3000);
				

				
				
	// Validate DashBoard
				BISMyAccountPage bmap = new BISMyAccountPage(driver);
				boolean targetpage = bmap.dashboardisDisplayed();
				
				if(res.equalsIgnoreCase("Valid"))
				{
					if(targetpage == true)
					{
						bmap.clickLogOut();
						Assert.assertTrue(true);
					}
					else
					{
						Assert.assertTrue(false);
					}
				}
				
				if(res.equalsIgnoreCase("Invalid"))
				{
					if(targetpage == true)
					{
						bmap.clickLogOut();
						Assert.assertTrue(false);
					}
					else
					{
						Assert.assertTrue(true);
					}
				}
	}

}
