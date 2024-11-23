package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLogin;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{	
	@Test(groups={"Sanity", "Master"})
	public void verify_Login()
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		logger.info("*** Opening My Account (Login) Page ***");
		
		AccountLogin login = new AccountLogin(driver);
		login.enterEmail(prop.getProperty("email"));
		login.enterPassword(prop.getProperty("password"));
		login.clickLogin();
		
		MyAccountPage accPage = new MyAccountPage(driver);
		
		String accText = accPage.getMyAccountLabel();
		Assert.assertEquals(accText, "My Account");		
		
	}
	
}
