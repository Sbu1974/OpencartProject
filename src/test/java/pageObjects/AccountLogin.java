package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogin extends BasePage
{

	public AccountLogin(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// Locators
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	// Actions
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	
}
