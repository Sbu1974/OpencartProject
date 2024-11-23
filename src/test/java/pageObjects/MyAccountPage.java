package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement lblMyAccount;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	// Actions
	public String getMyAccountLabel()
	{
		try
		{
			String myAccount = lblMyAccount.getText();
			return myAccount;
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
}
