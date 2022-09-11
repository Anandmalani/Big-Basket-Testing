package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input")
	WebElement searchField;
	
	@FindBy(xpath="//div[@id=\"navbar-main\"]/div/div[3]/div/div//button")
	WebElement searchButton;
	
	
	
	public void clickOnSearchField(String product) {
		searchField.sendKeys(product);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	

}
