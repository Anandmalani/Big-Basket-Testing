package loginTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class factoryClass {
	@FindBy(xpath="//div[@class=\"form-group\"]/input")
	public WebElement mobIn;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-default login-btn')]")
	public WebElement continueBtn;
	
	@FindBy(xpath="//*[@id=\"login\"]/login/div/form/div[1]/div/div")
	public WebElement errMsg;
	
	@FindBy(xpath="//button[@class=\"btn btn-default\"]")
	public WebElement emailBtn;
	
	@FindBy(id="mobile")
	public WebElement signupMob;
	
	@FindBy(xpath="//button[@class=\"btn btn-default signup-btn\"]")
	public WebElement signupMobBtn;
	
	@FindBy(id="otpEmail")
	public WebElement emailIn;
	
	@FindBy(id="fname")
	public WebElement fname;
	
	@FindBy(id="lname")
	public WebElement lname;
	
	@FindBy(id="email")
	public WebElement formEmail;
	
	@FindBy(xpath="//*[@id=\"signup\"]/div/signup/div[2]/button")
	public WebElement signupBtn;
		
	WebDriver driver;
	
	public factoryClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setMob(String u) {
		mobIn.sendKeys(u);
	}
	
	public void setSignupMob(String u) {
		mobIn.sendKeys(u);
	}
	
	public void setEmail(String e) {
		emailIn.sendKeys(e);
	}
	
	public void setFname(String f) {
		fname.sendKeys(f);
	}
	
	public void setLname(String l) {
		lname.sendKeys(l);
	}
	
	public void setFormEmail(String m) {
		formEmail.sendKeys(m);
	}
	
	public void clickCont() {
		continueBtn.click();
	}
	
	public void clickEmail() {
		emailBtn.click();
	}
	
	public void clickSignupMobBtn() {
		signupMobBtn.click();
	}
	
	public void clearMob() {
		mobIn.clear();
	}
	
	public void clearEmail() {
		emailIn.clear();
	}
	
}
