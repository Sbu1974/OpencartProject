package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	@Test(groups={"Regression", "Master"})
	public void verify_account_registration()
	{
		logger.info("***Starting test case: TC001_AccountRegistrationTest ****");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*** Clicking 'My Account' link ****");
			hp.clickRegister();
			logger.info("*** Clicking 'Register' link ****");
			
			AccountRegistration ar = new AccountRegistration(driver);
	
			logger.info("*** Entering User Details ****");
			ar.enterFirstName(randomString().toUpperCase());
			ar.enterLastName(randomString().toUpperCase());
			ar.enterEmail(randomString() + "@soap.com");
			ar.enterPhoneNumber(randomNumber());
			
			String pwd = randomAlphaNumeric();
	
			ar.enterPassword(pwd);
			ar.enterConfirmPassword(pwd);
			ar.acceptPolicy();
			ar.submitForm();
			logger.info("*** Submitting user details ****");
			
			String msg = ar.getConfirmationMessage();
			logger.info("*** Confirming successful registration ****");
			
			Assert.assertEquals(msg, "Your Account Has Been Created!");
			logger.info("*** Determining if test Passed/Failed ****");
		}
		catch (Exception e)
		{
			logger.error("Test failed...");
			logger.debug("Debug logs....");
			Assert.fail();
		}
		logger.info("***Finished test case: TC001_AccountRegistrationTest ****");
	}	
}
