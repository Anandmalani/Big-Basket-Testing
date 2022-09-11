package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//constructor
	public LoginPage(WebDriver driver) {
	        this.driver=driver;
	        PageFactory.initElements(driver, this);
	    }
	@FindBy(xpath="/html/body/div[1]/div/div/div/button")
	WebElement button;
	
	@FindBy(id="otpEmail")
	WebElement mobileNumber;
	
	@FindBy(xpath="//button[@class='btn btn-default login-btn']")
	WebElement continueButton;
	
	public void clickOnCrossButton() {
		button.click();
	}
	
	public void enterMobileNumber(String mobNum) {
		mobileNumber.sendKeys(mobNum);
	}
	
	public void clickOnContinueButton() {
		continueButton.click();
	}
	
}

