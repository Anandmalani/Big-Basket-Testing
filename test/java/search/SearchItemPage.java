package search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItemPage {
	@FindBy(xpath="//input[@id=\"input\"]")
	WebElement searchforProduct;
	 
	@FindBy(xpath="//button[@class='btn btn-default bb-search']")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"headerControllerId\"]/header/div/div/div/div/ul/li[3]/ul/li[2]/span[2]/a")
	WebElement loginButton;
	
	@FindBy(xpath="//div[@class=\"form-group\"]/input")
	WebElement enterMobileNumber;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-default login-btn')]")
	public WebElement continueBtn;
	
	@FindBy(xpath="//h2[@qa=\"pageName\"]/span")
	public WebElement resultText;
	
	@FindBy(xpath="//div[@class=\"uiv2-no-results-new\"]/p")
	public WebElement noResultText;
	 
	WebDriver driver;
	
	public SearchItemPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	public void  searchProduct(String itemName) {
		
		searchforProduct.sendKeys(itemName);
		
	}
	public void   clickOnSearchButton() {
		
		searchButton.click();
		
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	
	
	public void enterMobile(String itemName) {
		enterMobileNumber.sendKeys(itemName);
	}
	
	public void clickCont() {
		continueBtn.click();
	}
}
