package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage
{
	public AccountRegistration(WebDriver driver)
	{
		super(driver);
	}
	
	// Locators
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtPhoneNumber;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;	
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	// Actions
	public void enterFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}	

	public void enterLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}

	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void enterPhoneNumber(String phone)
	{
		txtPhoneNumber.sendKeys(phone);
	}

	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword)
	{
		txtConfirmPassword.sendKeys(confirmPassword);
	}

	public void acceptPolicy()
	{
		chkPolicy.click();
	}

	public void submitForm()
	{
		btnContinue.click();;
	}
	
	public String getConfirmationMessage()
	{
		try
		{
			return (msgConfirmation.getText());
		}
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}
	
}
