package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLogin;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")
	public void verify_LoginDDT(String email, String pwd, String exp)
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		AccountLogin login = new AccountLogin(driver);
		login.enterEmail(email);
		login.enterPassword(pwd);
		login.clickLogin();
		
		MyAccountPage accPage = new MyAccountPage(driver);
		String accText = accPage.getMyAccountLabel();
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if (accText.equalsIgnoreCase("My Account"))
			{
				accPage.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if (exp.equalsIgnoreCase("Invalid"))
		{
			if (accText.equalsIgnoreCase("My Account"))
			{
				accPage.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		
	}
}
